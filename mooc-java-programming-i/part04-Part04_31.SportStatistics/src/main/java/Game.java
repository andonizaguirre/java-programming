/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Game {

    private String homeTeam;
    private String visitorTeam;
    private int homePoints;
    private int visitorPoints;

    public Game(String home, String visitor, int homeP, int visitorP) {
        this.homeTeam = home;
        this.visitorTeam = visitor;
        this.homePoints = homeP;
        this.visitorPoints = visitorP;
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public String getVisitorTeam() {
        return this.visitorTeam;
    }

    public int getHomePoints() {
        return this.homePoints;
    }

    public int getVisitorPoints() {
        return this.visitorPoints;
    }

    public boolean gameWinner(String teamName) {
        if (teamName.equals(homeTeam) && this.homePoints > this.visitorPoints) {
            return true;
        } else if (teamName.equals(visitorTeam) && this.homePoints < this.visitorPoints) {
            return true;
        } else {
            return false;
        }
    }
}
