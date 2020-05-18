package com.matigou.web.vo;

import java.io.Serializable;
import java.util.Objects;

public class UserVo implements Serializable {
    private static final long serialVersionUID = -3256506167194058543L;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(username, userVo.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
