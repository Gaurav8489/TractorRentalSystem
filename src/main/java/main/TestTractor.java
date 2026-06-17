package main;

import dao.TractorDAO;

public class TestTractor {

    public static void main(String[] args) {

        TractorDAO dao = new TractorDAO();

        dao.viewTractors();
    }
}