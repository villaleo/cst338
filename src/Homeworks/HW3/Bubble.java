/**
 * Title: Bubble.java
 * Abstract: Defines a Bubble object which represents a thought bubble from a user. The
 *           user can set a username, emoticon, and message. Plagiarism is not allowed,
 *           that is, a user cannot set the same message as another user later that
 *           same day.
 * Author: Leonardo Villalobos
 * Date: 02/17/22
 */

package Homeworks.HW3;

public class Bubble {
    private String emoticon;
    private String name;
    private String username;
    private boolean verified;
    private String bubbleText;
    private BubbleDate date;
    private static int numBubbles = 0;
    private static int numFakeBubbles = 0;

    public Bubble(String emoticon, String name, String username, boolean verified) {
        this.emoticon = emoticon;
        this.name = name;
        this.username = username;
        this.verified = verified;
        numBubbles++;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setBText(String bubbleText) {
        if (bubbleText.length() > 140) {
            this.bubbleText = bubbleText.substring(0, 137) + "...";
            return;
        }
        this.bubbleText = bubbleText;
    }

    public void setDate(BubbleDate date) {
        this.date = date;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getBubbleText() {
        return bubbleText;
    }

    public BubbleDate getDate() {
        return date;
    }

    public static int getNumBubbles() {
        return numBubbles;
    }

    public static int getNumFakeBubbles() {
        return numFakeBubbles;
    }

    @Override
    public String toString() {
        String header = emoticon + " " + name;
        header += isVerified() ? " ✓ " : " ";
        header += "@" + username + "\n";

        String body = bubbleText + "\n";
        String footer = date.toString();
        return header + body + footer + '\n';
    }

    public boolean equals(Bubble otherBubble) {
        return bubbleText.equals(otherBubble.bubbleText);
    }

    public void plagiarismCheck(Bubble otherBubble) {
        final int SECONDS_IN_HOURS = 60 * 60;
        final int SECONDS_IN_MINUTES = 60;

        if (bubbleText.equals(otherBubble.bubbleText)) {
            var otherDate = otherBubble.getDate();
            int thisDateSeconds = date.getHour() * SECONDS_IN_HOURS + date.getMinute() * SECONDS_IN_MINUTES;
            int otherDateSeconds = otherDate.getHour() * SECONDS_IN_HOURS + otherDate.getMinute() * SECONDS_IN_MINUTES;

            if (otherDateSeconds > thisDateSeconds) {
                otherBubble.setBText("[Plagiarism detected. Text removed.]");
                numFakeBubbles++;
                numBubbles--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\n===== Welcome to Bubble! =====\n");

        // user @shakespeare
        Bubble shake = new Bubble("(7:^]", "William Shakespeare", "shakespeare", true);
        shake.setDate(new BubbleDate("November", 1, 1611, 3, 37, true));
        String shakeText = "Our revels now are ended. These our actors,\n"
                + "As I foretold you, were all spirits and\n"
                + "Are melted into air, into thin air:\n"
                + "And, like the baseless fabric of this vision,\n"
                + "The cloud-capp'd towers, the gorgeous palaces,\n"
                + "The solemn temples, the great globe itself,\n"
                + "Ye, all which it inherit, shall dissolve...";
        shake.setBText(shakeText);

        // user @fakeShake
        Bubble fakeShake = new Bubble("o_O", "Wilhelm Shakespeare", "fakeShake", false);
        fakeShake.setDate(new BubbleDate("November", 1, 1611, 6, 42, false));
        fakeShake.setBText(shakeText);

        // user @JasonStraffen15
        Bubble jStraffen = new Bubble("(ツ)", "J", "JasonStraffen15", false);
        BubbleDate jsDate = new BubbleDate("Oct", 10, 2018, 2, 18, false);
        jStraffen.setDate(jsDate);
        String jsText = "dude imagine being a bug and accidentally\n"
                + "getting stuck in a car and driving far af away\n"
                + "from everything you know";
        jStraffen.setBText(jsText);


        //user @ArielDumas
        Bubble aDumas = new Bubble("(ಠ_ಠ)", "Ariel Dumas", "ArielDumas", true);
        aDumas.setDate(new BubbleDate("Oct", 11, 2021, 4, 36, false));
        aDumas.setBText("You telling me this foam has memories?");

        shake.plagiarismCheck(fakeShake);
        aDumas.plagiarismCheck(jStraffen);

        System.out.println(shake);
        System.out.println(fakeShake);
        System.out.println(jStraffen);
        System.out.println(aDumas);

        System.out.println("===== End of Bubble feed =====\n");
        System.out.printf("Bubble has shipped a total of %d bubble(s)"
                + " and detected %d fake bubble(s).%n", Bubble.getNumBubbles(), Bubble.getNumFakeBubbles());
    }
}
