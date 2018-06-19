package main.java.launcher.configmodifier;

import java.io.*;
import java.util.regex.Pattern;

public class ConfigModifier
{
    private File settingsFile;
    private String content;
    private String outputFilePath;

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
        settingsFile = new File(filePath);
    }

    public void readFile(){
        content = readFileToString(settingsFile);
    }

    public void setOutputFilePath(String outputFilePath){
        this.outputFilePath = outputFilePath;
    }

    public void writeFile(){
        writeFile(outputFilePath, content);
    }

    public File getFile(){
        return this.settingsFile;
    }

    /**
     * Reading a file to a string.
     * @param file the file to read
     * @return A string containing the content of the file
     */
    private String readFileToString(File file){
        StringBuffer inputBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
     * @param stringToBeReplaced The string that needs to be replaced
     * @param replaceToString The string that it needs to be replaced to
     * @return The resulting string with the replacement
     */
    public void replaceString(String stringToBeReplaced, String replaceToString){
        content = content.replaceFirst(Pattern.quote(stringToBeReplaced), replaceToString);
    }

    /**
     * Writing a string to a filepath.
     * @param filePath The output path of the file
     * @param content The content that needs to be written to the file
     */
    private void writeFile(String filePath, String content){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
