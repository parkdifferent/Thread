package Reflection;

/**
 * Created by tianf on 2016/8/19.
 */
public class Employee {

    private Integer eno;
    private String ename;

    public Employee() {

    }

    public Employee(Integer eno, String ename) {
        this.eno = eno;
        this.ename = ename;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }


    public void getMessage() {
        System.out.println("工号"+eno+" ，姓名："+ename);
    }


    public String hello(String name) {
        return name+" 你好! ";

    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
