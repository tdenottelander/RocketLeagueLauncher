package main.java.launcher.configmodifier;

public class RLConfigModifier extends ConfigModifier
{

    /**
     * Create a ConfigModifier object with loading the file to be changed.
     *
     * @param filePath
     */
    public RLConfigModifier(String filePath)
    {
        super(filePath);
    }

    public void setWide(){
        if(content.contains("ResX=1920")){
            replaceString("ResX=1920", "ResX=3840");
            //TODO Borderless functionality
        } else {
            //TODO Borderless functionality
        }
    }

    public void setNormal(){
        if(content.contains("ResX=3840")){
            replaceString("ResX=3840", "ResX=1920");
            //TODO Borderless functionality
        } else {
            //TODO Borderless functionality
        }
    }
}
