import java.time.LocalTime;
import java.time.Duration;
import java.util.Random;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class TheaterSimulation{
 public static void main(String[] args) {
	 Theater theatre = new Theater();
	 System.out.println("Day 1");
	 theatre.schedule();
	 theatre.sellTickets();
	 System.out.println("Day 2");
	 theatre.schedule();
	 theatre.sellTickets();
	 System.out.println("Day 3");
	 theatre.schedule();
	 theatre.sellTickets();
  }
}
  class Movie {
    private String title;
    private int duration;
    private double popularity;
    public Movie(String s, int i, double d){
      title = s;
      duration = i;
      popularity = d;
    }
    public double getPopularity(){
      return popularity;
    }
    public int getDuration(){
      return duration;
    }
    public String toString(){
      return title + "  (" + duration + " minutes)";
    }
  }
  class Auditorium {
    private int id, capacity;
    public Auditorium(int ID, int cap){
      id = ID;
      capacity = cap;
    }
    public int getCapacity(){
      return capacity;
    }

    public String toString(){
      return "Auditorium #" + id;
    }
  }
  class Showing {
    private Movie movie;
    private Auditorium auditorium;
    private LocalTime showTime;
    public Showing(Movie m, Auditorium a, LocalTime show){
      movie = m;
      auditorium = a;
      showTime = show;
    }
    public Auditorium getAuditorium(){
      return auditorium;
    }
    public LocalTime getShowTime(){
      return showTime;
    }
    public Movie getMovie(){
        return movie;
      }
    public String toString(){
      return movie + " " + auditorium + " " + showTime;
    }
  }

  class Theater{
    static Random random = new Random();
    static int timeBetweenShowings = 15;
    LocalTime firstShowTime, lastShowTime;
    double ticketPrice;
    ArrayList <Movie> movies = new ArrayList<>(); //a selection of movies the Theater has the rights to show
    ArrayList <Auditorium> auditoriums = new ArrayList<>(); //the various auditoriums the theater contains for showing movies
    ArrayList <Showing> showings = new ArrayList<>(); //essentially the schedule of movie showings for the day
    DecimalFormat round = new DecimalFormat("#.##");
    public Theater(){
      firstShowTime = LocalTime.of(10, 00);
      lastShowTime = LocalTime.of(23, 00);
      ticketPrice = 15.99;
      Movie movie1 = new Movie("When Harry Met Sally", 95, 8.9);
      movies.add(movie1);
      Movie movie2 = new Movie("The Black Cauldron", 80, 6.5);
      movies.add(movie2);
      Movie movie3 = new Movie("Coco", 105, 9.7);
      movies.add(movie3);
      Movie movie4 = new Movie("Crimson Peak", 119, 4.4);
      movies.add(movie4);
      Movie movie5 = new Movie("Wonder Woman", 141, 9.9);
      movies.add(movie5);
      Movie movie6 = new Movie("Shadow & Bone", 60, 10); // Coming soon to Netflix! At my theater we somehow have access even though it's filming now
      movies.add(movie6);
      Movie movie7 = new Movie("Beyond the Lights", 80, 6.9);
      movies.add(movie7);
      Movie movie8 = new Movie("Heathers", 103, 8.8);
      movies.add(movie8);
      Movie movie9 = new Movie("Split", 117, 9.3);
      movies.add(movie9);
      Movie movie10 = new Movie("Black Swan", 108, 9.5);
      movies.add(movie10);
      Auditorium aud1 = new Auditorium(1, 73);
      auditoriums.add(aud1);
      Auditorium aud2 = new Auditorium(2, 169);
      auditoriums.add(aud2);
      Auditorium aud3 = new Auditorium(3, 87);
      auditoriums.add(aud3);
    }

    private Movie randomMovie(ArrayList <Movie> moviez){
      Random x = new Random();
      return moviez.get(x.nextInt(moviez.size()));
    }
    public void schedule(){
    	showings.clear();
        for(Auditorium eachAud : auditoriums){
        	LocalTime current = firstShowTime;
        	while(current.isBefore(lastShowTime) && current.isAfter(firstShowTime.minusMinutes(1))){
                Movie standInMovie = randomMovie(movies);
                Showing show = new Showing(standInMovie, eachAud, current);
                showings.add(show);
                current = current.plus(Duration.ofMinutes(standInMovie.getDuration()));
                current = current.plus(Duration.ofMinutes(timeBetweenShowings));
                //System.out.println(show);
              }
        }
    }
    public void sellTickets(){
    	double totalProfit = 0;
    	int totalTicketsSold = 0;
    	  for(Showing shows: showings){
    	        Movie currentMovie = shows.getMovie();
    	        double currentPopularity = currentMovie.getPopularity();
    	        Auditorium currentAuditorium = shows.getAuditorium();
    	        int currentCap = currentAuditorium.getCapacity();
    	        int ticketsSold = (int) (currentCap*(currentPopularity/10));
    	        double profit = ticketsSold*ticketPrice;
    	        totalProfit += profit;
    	        totalTicketsSold += ticketsSold;
    	        System.out.println(shows + " tickets sold " + ticketsSold + " $" + round.format(profit));
    	      }
		System.out.println("Tickets sold today: " + totalTicketsSold + " Profit made: $" + round.format(totalProfit));
    }

  }
