package common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;

public class DriverJsonFile {
    @SuppressWarnings("unchecked")
    public static void writeJsonFile(String username, String password,JSONArray accountList,String register){
        try {
            FileWriter file;
            if(register.equals("registered")) {
                file = new FileWriter("src/main/resources/accountRegistered.json");
            }else {
                file = new FileWriter("src/main/resources/accountUnregistered.json");
            }
            //First account
            JSONObject accountDetails = new JSONObject();
            accountDetails.put("username", username);
            accountDetails.put("password", password);

            JSONObject accountObject = new JSONObject();
            accountObject.put("account", accountDetails);
            accountList.add(accountObject);

            //We can write any JSONArray or JSONObject instance to the file
            file.write(accountList.toJSONString());
            file.flush();
            System.out.println(accountList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getInfoObject(JSONObject account,String accName,String info){
        try {
            JSONObject accountObject = (JSONObject) account.get(accName);
            System.out.println(accountObject.get(info).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static JSONArray readJsonFileRegister() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/accountRegistered.json"))
        {
            //Read JSON file
            JSONArray accountList = (JSONArray) jsonParser.parse(reader);
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray readJsonFileUnregister() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/accountUnregistered.json"))
        {
            //Read JSON file
            JSONArray accountList = (JSONArray) jsonParser.parse(reader);
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        JSONArray accountList = readJsonFileRegister();
        writeJsonFile("le@gmail.com", "123465798", accountList,"registered");
        for(int i = 0; i<accountList.size();i++) {
            JSONObject account = (JSONObject) accountList.get(i);
            getInfoObject(account, "account1", "username");
        }
    }
}
