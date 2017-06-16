/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author artur
 */
public class Metodos {

    static ConfigurationBuilder cb;
    static twitter4j.Twitter twitter;
    static Status status;
    static DirectMessage message;
    static ArrayList<Status> twits = new ArrayList<Status>();
    static Iterator<Status> it = twits.iterator();

    public Metodos() {

    }

    public static void conexion() {

        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("Gcrf2sB8k3Fufj2DvGKJ927Km");
        cb.setOAuthConsumerSecret("j6KZ1B7vFYMomHOOWAh8w54FNdFiRWsWKlDnXkqvB9xHZncKwa");
        cb.setOAuthAccessToken("1139875974-WgY9HsYvOGiGx7PuFux2yYBSdJjoIBAuOUpklno");
        cb.setOAuthAccessTokenSecret("NTjavWoKCB3HiYCTQh3A2cqFogI3aaDf1myF1E98FKZzp");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public static void lineaTiempo() {

        List<Status> statuses;
        try {
            statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);

            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void twittear(String latestStatus) {
        try {
            status = twitter.updateStatus(latestStatus);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void buscarTwit(String busqueda) {

        Query query = new Query(busqueda);
        QueryResult result;
        try {
            result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());

            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
