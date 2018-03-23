package irc.irc__client;

/**
 * Created by Czarek on 2018-02-24.
 */
public class Parser {
    String data;
    String [] tags;
    String prefix;
    String command;
    String [] params;

    int positionIndex = 0;
    int endOfTags = 0;
    int endOfPrefix = 0;
    int endOfCommand = 0;
    int endOfParams = 0;

    public Parser(){
        data = null;
        tags = null;
        prefix = null;
        command = null;
        params = null;
    }

    public void sliceMessage(String serverOutput){
        this.data = serverOutput;

        //parse tags
        if(data.startsWith("@")){
            endOfTags = data.indexOf(" ");
            if (endOfTags == -1) {
                System.out.println("Parsing error: Couldn't find whitespace after tags: " + data);
                return;
            }
            positionIndex = data.indexOf(" ");
            //TODO method to slice tags and put them in tags HashMap
        }

        skipWhitespaces();

        //parse prefix
        if(data.charAt(positionIndex) == ':'){
            endOfPrefix = data.indexOf(" ", positionIndex);
            prefix = data.substring(positionIndex,endOfPrefix);
            //TODO prefix slicing method
            positionIndex = endOfPrefix;
        }

        skipWhitespaces();

        //command parsing
        endOfCommand = data.indexOf(" ", positionIndex);
        command = data.substring(positionIndex, endOfCommand);
        positionIndex = endOfCommand;

        skipWhitespaces();

        //params parsing
        endOfParams = data.length();
        params = data.substring(positionIndex, endOfParams).split(" ");
    }
    private void skipWhitespaces() {
        while (data.charAt(positionIndex) == ' ') positionIndex++;
    }

    public void showResult(){
        System.out.println(data);
        System.out.println("Tags: " + tags);
        System.out.println("Prefix: " + prefix);
        System.out.println("Command: " + command);
        System.out.println("Params: " + params[0] + " " + params[1]);
        System.out.println(" ");
    }
}

