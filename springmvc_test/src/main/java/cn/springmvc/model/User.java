package cn.springmvc.model;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "User{name = "+name+"}";
    }
}
