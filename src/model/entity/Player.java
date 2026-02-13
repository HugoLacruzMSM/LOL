package model.entity;

import java.util.Objects;

public class Player {
    String username;
    int level;
    String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        String unranked = "Unranked";
        this.rank = Objects.requireNonNullElse(rank, unranked);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return ("--- "+ username + " - lvl("+rank+") rank("+level+") ---");
    }
}
