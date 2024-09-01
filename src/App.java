import java.io.*;


public class App {
    public static void main(String[] args) throws Exception {

        String directory = "directory";
        String backup = "backup";
        File folder =new File(directory);
        for (File file : folder.listFiles()) {
            String backupFile = String.format("%s/%s", backup,file.getName());
            try(BufferedInputStream instream = new BufferedInputStream(new FileInputStream(file.getPath()));
            BufferedOutputStream outstream = new BufferedOutputStream(new FileOutputStream(backupFile))){
                //System.out.println(instream.readAllBytes().length);
                byte [] buffer = instream.readAllBytes();
                outstream.write(buffer,0,buffer.length);
    
            }
            catch(IOException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    }
}
