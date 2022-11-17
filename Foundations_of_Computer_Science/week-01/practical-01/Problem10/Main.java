public class Main{
	public static void main(String [] args){

        // Declaring string
        String agent_message_01282 = "Who are you?";

        // Printing it out
        System.out.println(agent_message_01282);

        // Changing the value of the variable
        agent_message_01282 = "My name is, Bond...";

        // Printing it out after changing
        System.out.println(agent_message_01282);

        agent_message_01282 = "James Bond";

        System.out.println(agent_message_01282);

        // Declaring integer
        int agent_id = 007;

        agent_message_01282 = agent_message_01282 + "(00" + agent_id + ")";

        System.out.println(agent_message_01282);

    }
}