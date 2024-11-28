package com.jpan.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "chess_match")
public class Match {
    @Id
    @Column(name = "match_no")
    private int matchNo;
    @Column(name = "tournament_nm")
    private String tournamentName;
    @Column(name = "match_dt")
    private LocalDate matchDate;
    @Column(name = "player1_nm")
    private String player1Name;
    @Column(name = "player2_nm")
    private String player2Name;
    private String location;

    public int getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(int matchNo) {
        this.matchNo = matchNo;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return getMatchNo() == match.getMatchNo() && Objects.equals(getTournamentName(), match.getTournamentName()) && Objects.equals(getMatchDate(), match.getMatchDate()) && Objects.equals(getPlayer1Name(), match.getPlayer1Name()) && Objects.equals(getPlayer2Name(), match.getPlayer2Name()) && Objects.equals(getLocation(), match.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchNo(), getTournamentName(), getMatchDate(), getPlayer1Name(), getPlayer2Name(), getLocation());
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchNo=" + matchNo +
                ", tournamentName='" + tournamentName + '\'' +
                ", matchDate=" + matchDate +
                ", player1Name='" + player1Name + '\'' +
                ", player2Name='" + player2Name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
