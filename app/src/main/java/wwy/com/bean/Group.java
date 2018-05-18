package wwy.com.bean;

import java.util.List;

/**
 * --------------------------------------------
 * auther :  WWY
 * 2018/02/26 10:18
 * description ：
 * -------------------------------------------
 **/
public class Group {

    private String groupName;
    private String gropAge;
    private List<User> members;

    public String getGropAge() {
        return gropAge;
    }

    public void setGropAge(String gropAge) {
        this.gropAge = gropAge;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
