package com.leanquizzmind.lean_quizz_mind.infraestructure.entities;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "rankings")
public class RankingEntity {

    @Column(name = "rankingId", nullable = false)
    private UUID rankingId;

    @Column(name = "nickname", nullable = false)
    private Text nickname;

    @Column(name = "points", nullable = false)
    private float points;

    @Column(name = "time", nullable = false)
    private Time time;

    public RankingEntity() {}

    public RankingEntity(UUID rankingId, Text nickname, float points, Time time) {
        this.rankingId = rankingId;
        this.nickname = nickname;
        this.points = points;
        this.time = time;
    }

    public RankingEntity(Text nickname, float points, Time time) {
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

    public Text getNickname() {
        return nickname;
    }

    public void setNickname(Text nickname) {
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
