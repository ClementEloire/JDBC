/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesvols;

import java.sql.*;
/**
 *
 * @author pedago
 */
public class GestionDesVols {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("yes ");
        }catch(java.lang.ClassNotFoundException e){
            System.err.println("nul "+ e.getMessage());
        }
        
        try{
            String url ="jdbc:postgresql://localhost:5432/postgres";
            String user ="postgres";
            String passwd ="postgres";
            conn = DriverManager.getConnection(url, user, passwd);
            if(conn !=null){
                System.out.println("yes");
            }else{
                System.out.println("nul");
            }
            
        AfficheTableAvion(conn); 
        AfficheTablePilot(conn);
        SalaireMoyen(conn);
        SommeCapaciterAvion(conn);
                
                
                
                
        
        }catch(SQLException ex){
            System.err.println("exception SQL");
        } 
        if(conn !=null){try{
            conn.close();
            System.out.println("Connexion close");
        }catch(Exception e){
            System.err.println("erreur");
        }
        }
    }
    
    
    
    
    public static void AfficheTableAvion(Connection con)throws SQLException{
        String requete = "Select * From Avion";
        try{
            Statement stmt =null;
            stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(requete); 
        if(rset !=null){
            while(rset.next()){
                System.out.println("\t Numéro : "+ rset.getInt(1)+"\t");
                System.out.println("\t Nom : "+ rset.getString(2)+"\t");
                System.out.println("\t Capacité : "+ rset.getInt(3)+"\t");
                System.out.println("\t Localisation : "+ rset.getString(4)+"\t");
                System.out.println("\n---------------------------------");
            }
            System.out.println();
        }else{
            throw new SQLException("Raté");
        }
        rset.close();// fermeture de l'instance ResultSet           
        stmt.close();  // fermeture de l'instance Statement
        }catch(SQLException e){       
            System.err.println("Nul!");
        }
    }
    
    
    
    
    public static void AfficheTablePilot(Connection con)throws SQLException{
        String requete = "Select * From Pilote";
        try{
            Statement stmt =null;
            stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(requete); 
        if(rset !=null){
            while(rset.next()){
                System.out.println("\t Numéro : "+ rset.getInt(1)+"\t");
                System.out.println("\t Nom : "+ rset.getString(2)+"\t");
                System.out.println("\t Prenom : "+ rset.getString(3)+"\t");
                System.out.println("\t Ville : "+ rset.getString(4)+"\t");
                System.out.println("\t Ddn : "+ rset.getDate(5)+"\t");
                System.out.println("\t Salaire : "+ rset.getFloat(6)+"\t");
                System.out.println("\n---------------------------------");
            }
            System.out.println();
        }else{
            throw new SQLException("Raté");
        }
        rset.close();  // fermeture de l'instance ResultSet           
        stmt.close();  // fermeture de l'instance Statement
        }catch(SQLException e){       
            System.err.println("Nul!");
        }
    }
    
    
    
    public static void SalaireMoyen(Connection con)throws SQLException{
        String requete = "Select Sum(Salaire)/Count(plnom) From Pilote";
        try{
            Statement stmt =null;
            stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(requete); 
        if(rset !=null){
            while(rset.next()){
                System.out.println("\t Salaire Moyen : "+ rset.getInt(1)+"\t");
                System.out.println("\n---------------------------------");
            }
            System.out.println();
        }else{
            throw new SQLException("Raté");
        }
        rset.close();  // fermeture de l'instance ResultSet           
        stmt.close();  // fermeture de l'instance Statement
        }catch(SQLException e){       
            System.err.println("Nul!");
        }
    }
    
    
    public static void SommeCapaciterAvion(Connection con)throws SQLException{
        String requete = "Select Sum(CAPACITE) From Avion";
        try{
            Statement stmt =null;
            stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(requete); 
        if(rset !=null){
            while(rset.next()){
                System.out.println("\t Total de place : "+ rset.getInt(1)+"\t");
                System.out.println("\n---------------------------------");
            }
            System.out.println();
        }else{
            throw new SQLException("Raté");
        }
        rset.close();  // fermeture de l'instance ResultSet           
        stmt.close();  // fermeture de l'instance Statement
        }catch(SQLException e){       
            System.err.println("Nul!");
        }
    }
    
    
    
}
    
