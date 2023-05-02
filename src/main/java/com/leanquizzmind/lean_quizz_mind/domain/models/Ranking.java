package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.sql.Time;
import java.util.UUID;

public class Ranking {

    private UUID rankingId = UUID.randomUUID();
    private String nickname;
    private float points;
    private Time time;

    public Ranking() {}

    public Ranking(UUID rankingId, String nickname, float points, Time time) {
        this.rankingId = rankingId;
        this.nickname = nickname;
        this.points = points;
        this.time = time;
    }

    public UUID getRankingId() {
        return rankingId;
    }

    public void setRankingId(UUID rankingId) {
        this.rankingId = rankingId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
