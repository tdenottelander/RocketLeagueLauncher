package main.java.launcher.configmodifier;

import java.io.*;
import java.util.regex.Pattern;

public class ConfigModifier
{

    private File settingsFile;

    /**
     * Create a ConfigModifier object with loading the file to be changed.
     * @param filePath
     */
    public ConfigModifier(String filePath) {
        loadFile(filePath);
    }

    /**
     * Create a ConfigModifier object without setting the settingsFile.
     */
    public ConfigModifier(){}

    private void loadFile(String filePath) {
        settingsFile = new File("src/test/resources/TASystemSettings.ini");
    }

    public File getFile(){
        return this.settingsFile;
    }

    /**
     * Change the content of a file and write the changes to a file.
     * @param inputFilePath The path to the input file
     * @param outputFilePath The path to the output file (possibly the same as input)
     */
    public void changeContent(String inputFilePath, String outputFilePath){
        String content = readFileToString(inputFilePath);

        //System.out.println(content);

        content = replaceString(content,"ResX=1920", "ResX=3840");

        writeFile(outputFilePath, content);
    }

    /**
     * Reading a file to a string.
     * @param filePath the path to the file
     * @return A string containing the content of the file
     */
    public String readFileToString(String filePath){
        StringBuffer inputBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                inputBuffer.append(line);
                inputBuffer.append("\n");
            }

            bufferedReader.close();

            return inputBuffer.toString();
        } catch (IOException e){
            e.printStackTrace();
        }
        return inputBuffer.toString();
    }

    /**
     * Replace some part of the string with another string.
     * @param content The content that needs a change
     * @param stringToBeReplaced The string that needs to be replaced
     * @param replaceToString The string that it needs to be replaced to
     * @return The resulting string with the replacement
     */
    public String replaceString(String content, String stringToBeReplaced, String replaceToString){
        return content.replaceFirst(Pattern.quote(stringToBeReplaced), replaceToString);
    }

    /**
     * Writing a string to a filepath.
     * @param filePath The output path of the file
     * @param content The content that needs to be written to the file
     */
    public void writeFile(String filePath, String content){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
