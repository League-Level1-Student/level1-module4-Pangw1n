package _99_extra._02_simon_says;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import game_tools.Sound;

public class SimonSays extends KeyAdapter {
    HashMap<Integer, String> images = new HashMap<Integer, String>();
    private int imageIndex;
    private int tries = 0;
    private boolean simonSays = false;
    Date timeAtStart;
    
    int points;

    // Complete steps 1 - 7 before you test
    // 1. Declare a JFrame variable
    JFrame frame;

    public void run() {
        // 2. Add the four images that match keyboard keys like this:
        // images.put(KeyEvent.VK_UP, "up.jpg");
    	images.put(KeyEvent.VK_UP, "up.jpg");
    	images.put(KeyEvent.VK_LEFT, "left.jpg");
    	images.put(KeyEvent.VK_DOWN, "down.jpg");
    	images.put(KeyEvent.VK_RIGHT, "right.jpg");
        // 3. Use a JOptionPane to tell the user the rules: "Press the matching
        // key when
        // 'Simon says' otherwise press a different key"
    	JOptionPane.showMessageDialog(null, "Press the matching key when 'Simon says' otherwise press a different key.");
        // 4. Call the showImage method to show an image
    	showImage();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 15. Make a points variable to track the score.
    	
        // 16. If the keyCode matches the imageIndex and "Simon says"
    	if (e.getKeyCode() == Integer.parseInt(images.get(imageIndex)) && simonSays);
    	{
    	// 17. Increase the value of score
    		points ++;
        // 18. Use the Sound.speak method to tell the user they were correct
    		Sound.speak("Correct");
    	}
        // 19. If the keyCode doesn't match the imageIndex and "Simon didn't
        // say..."
        if (e.getKeyCode() != Integer.parseInt(images.get(imageIndex)) && !simonSays)
        {
    	// 20. Increase the value of score
        	points ++;
        // 21. Use the Sound.speak method to tell the user they were correct
        	Sound.speak("Correct");
        }
        // 22. Increment tries by 1
        tries ++;
        // 25. If tries is greater than 9 (or however many you want)...
        if (tries > 9)
        {
        // 26. Tell the user their score
        	JOptionPane.showMessageDialog(null, points);
        // 27. Exit the program
        	System.exit(0);
        // 23. Dispose of the frame
        	frame.dispose();
        }
        // 24. Call the showImage method to show a new image
        showImage();
    }

    private void showImage() {
        // 5. Initialize your frame to a new JFrame()
    	frame = new JFrame();
        // 6. Set the frame to visible
    	frame.setVisible(true);
        // 7. Uncomment the following line to add a random image to your frame
    	frame.add(getNextRandomImage());
    	
        // 8. Set the name of your frame
    	frame.setName("Simon Says");
        // 9. Pack the frame
    	frame.pack();
        // 10. Set the defaultCloseOperation of your frame to
        // JFrame.EXIT_ON_CLOSE
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 11. Add a key listener to the frame
    	frame.addKeyListener(this);
        // 12. Create a new instance of Random
    	int rand = new Random().nextInt(2);
        // 13. Use the Random and the Sound.speak method to either say
        // "Simon says press this key" or "Press this key"
    	if (rand == 1)
    	{
    		Sound.speak("Simon says press this key");
    		simonSays = true;
    	}
    	else
    	{
    		Sound.speak("Press this key");
    		simonSays = false;
    	}
        // 14. Above, set the value of simonSays to true/false appropriately

    }

    private Component getNextRandomImage() {
        this.imageIndex = new Random().nextInt(4) + 37;
        return loadImage(images.get(imageIndex));
    }

    private JLabel loadImage(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = new ImageIcon(imageURL);
        return new JLabel(icon);
    }
}

/*
 * BONUS! Add a timer : ~~~ where the code starts running ~~~ timeAtStart =
 * newDate();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
