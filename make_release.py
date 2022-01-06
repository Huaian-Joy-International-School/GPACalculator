import os
import shutil
import zipfile

RELEASE_DIR = 'release'
OUTPUT_DIR = 'target'
JAVA_NAME = 'jdk-16.0.1'
JAVA_DIR = os.path.join(RELEASE_DIR, JAVA_NAME)


def get_root():
    import xml.etree.cElementTree as ET
    return ET.ElementTree(file='pom.xml').getroot()


def get_name():
    return get_root().find('{http://maven.apache.org/POM/4.0.0}artifactId').text


def get_version():
    return get_root().find('{http://maven.apache.org/POM/4.0.0}version').text


def make_dir(name):
    if not os.path.isdir(name):
        os.makedirs(name)


def rm_dir(name):
    if os.path.isdir(name):
        shutil.rmtree(name)


def main():
    name = get_name()
    version = get_version()
    release_id = f'{name}-{version}'
    this_release_dir = os.path.join(RELEASE_DIR, release_id)
    jar_path = os.path.join(
        OUTPUT_DIR,
        f'{release_id}-jar-with-dependencies.jar'
    )
    make_dir(this_release_dir)

    # 主程序
    shutil.copy(jar_path, os.path.join(this_release_dir, f'{release_id}.jar'))

    # Windows
    win_release_dir = os.path.join(this_release_dir, f'{release_id}_win')
    win_release_path = os.path.join(this_release_dir, f'{release_id}_win.zip')
    # 创建文件夹
    make_dir(win_release_dir)
    # 复制主程序
    shutil.copy(jar_path, os.path.join(win_release_dir, f'{release_id}.jar'))
    # 复制Java
    shutil.copytree(JAVA_DIR, os.path.join(win_release_dir, JAVA_NAME))
    # 生成启动脚本
    with open(os.path.join(win_release_dir, 'RunMe.bat'), 'w') as f:
        content = '@echo off\n'
        content += rf'jdk-16.0.1\bin\java.exe -jar {release_id}.jar'
        f.write(content)
    # 压缩
    with zipfile.ZipFile(win_release_path, 'w') as z:
        for root, dirs, files in os.walk(win_release_dir):
            for file in files:
                filename = os.path.join(root, file)
                arc_name = filename.replace(this_release_dir, '').lstrip('\\')
                z.write(filename, arc_name)
    # 删除文件夹
    rm_dir(win_release_dir)


if __name__ == '__main__':
    main()
