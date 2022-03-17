package com.company;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Instance {

    private String name;

    public enum type_enum {
        TSP, ATSP
    }

    private type_enum type;

    private int dimension;

    public enum edge_weight_type_enum {
        EXPLICIT, EUC_2D
    }
    private edge_weight_type_enum edge_weight_type;

    public enum edge_weight_format_enum {
        FULL_MATRIX, LOWER_DIAG_ROW
    }
    private edge_weight_format_enum edge_weight_format;

    /*private enum edge_data_format_enum {
        EDGE_LIST, ADJ_LIST;
    }
    private edge_data_format_enum edge_data_format;
    private enum node_coord_type_enum {
        TWOD_COORDS, THREED_COORDS, NO_COORDS;
    }
    private node_coord_type_enum node_coord_type;
    */
    public enum display_data_type_enum {
        COORD_DISPLAY, TWO_DISPLAY, NO_DISPLAY
    }
    private display_data_type_enum display_data_type;

    public ArrayList<Point2D.Double> node_coord_list;
    public int[][] edge_weight_matrix;

    public String getName() {
        return name;
    }

    public type_enum getType() {
        return type;
    }

    public int getDimension() {
        return dimension;
    }

    public edge_weight_type_enum getEdge_weight_type() {
        return edge_weight_type;
    }

    public edge_weight_format_enum getEdge_weight_format() {
        return edge_weight_format;
    }

    public display_data_type_enum getDisplay_data_type() {
        return display_data_type;
    }

    public void setType(type_enum type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setEdge_weight_type(edge_weight_type_enum edge_weight_type) {
        this.edge_weight_type = edge_weight_type;
    }

    public void setEdge_weight_format(edge_weight_format_enum edge_weight_format) {
        this.edge_weight_format = edge_weight_format;
    }

    public void setDisplay_data_type(display_data_type_enum display_data_type) {
        this.display_data_type = display_data_type;
    }

    public void printList(){
        int i = 0;
        while(i<node_coord_list.size()){
            System.out.println(node_coord_list.get(i));
            i++;
        }
    }


    public Instance() {

    }

    public void generateRandomInstanceEUC_2D(int size, int upper){

        Random rand = new Random();
        int x;
        int y;
        ArrayList<Point2D.Double> pom_list = new ArrayList<>();
        int i = 0;
        while(i<size){
            x = rand.nextInt(upper);
            y = rand.nextInt(upper);
            Point2D.Double point = new Point2D.Double(x,y);
            pom_list.add(point);
            i++;
        }
        this.node_coord_list = pom_list;
    }

    public Solution getSolution(){
        System.out.println(node_coord_list.size());
        Solution solution = new Solution(node_coord_list.size(),edge_weight_matrix);
        return solution;
    }

    public void visualize(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,500);
    }

    public int getDistance(int n, int m){
        return (int) (Math.sqrt(((node_coord_list.get(n).getX()-node_coord_list.get(m).getX())*(node_coord_list.get(n).getX()-node_coord_list.get(m).getX()))
                +((node_coord_list.get(n).getX()-node_coord_list.get(m).getX())*(node_coord_list.get(n).getX()-node_coord_list.get(m).getX())))+0.5);
    }

    public void printMatrix(int limit){
        int i = 0;
        int j = 0;
        while(i<limit){
            j = 0;
            while (j < limit) {
                System.out.print(edge_weight_matrix[i][j] + " ");
                j++;
            }
            System.out.println(" ");
            i++;
        }
    }

}