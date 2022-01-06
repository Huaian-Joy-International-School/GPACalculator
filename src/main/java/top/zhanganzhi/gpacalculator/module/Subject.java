package top.zhanganzhi.gpacalculator.module;


public class Subject {
    private final String type;
    private final String name;
    private final double credit;

    public Subject(String typeName, String name, double credit) {
        this.type = typeName;
        this.name = name;
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
