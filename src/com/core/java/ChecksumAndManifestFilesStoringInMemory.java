package com.core.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class ChecksumAndManifestFilesStoringInMemory {

    private static final String FILE_STORAGE_PATH = "D:\\checksum";
    //private static final String S3_BUCKET_NAME = "your-s3-bucket";

    private static int fileCount = 0;
    
    private static final List<Path> fileArrayList = new ArrayList<>();

    public static void main(String[] args) {
        // Simulate processing Kafka messages
        IntStream.range(0, 5).forEach(i -> processKafkaMessage(("Message " + i).getBytes()));
    }

    private static void processKafkaMessage(byte[] messageBytes) {
        // Generate a file name using UUID
        String fileName = UUID.randomUUID().toString();

        // Process the Kafka message, e.g., calculate checksum
        UUID checksumUuid = calculateChecksum(messageBytes);

        // Save the checksum to a local file and upload to S3
        saveAndUpload(fileName, checksumUuid);

        // Log or further process the checksum
        //System.out.println("Checksum saved to local file and uploaded to S3: " + fileName);
    }

    private static UUID calculateChecksum(byte[] messageBytes) {
        // Simulated checksum calculation
        return UUID.nameUUIDFromBytes(messageBytes);
    }

    private static void saveAndUpload(String fileName, UUID checksumUuid) {
        try {
            
            Path filePath = Paths.get(fileName + ".info");
            
         // Construct the local file path
            Path localFilePath = Paths.get(FILE_STORAGE_PATH, fileName + ".txt");

            // Write the content to the local file
            String content = fileName + "|" + checksumUuid + "|" + ++fileCount + "|" + getFormattedTimestamp();
            Files.write(filePath, content.getBytes());
            
            //writing content to local files
            Files.write(localFilePath, content.getBytes());
            
            fileArrayList.add(filePath.toAbsolutePath());
            
            System.out.println("files present int the arraylist are :");
            System.out.println("list of files in the arraylist : " + fileArrayList);
            
            System.out.println("files present int the local directory :");
            System.out.println("list of files in the local directory : " + localFilePath);
            
            //System.out.println("Checksum saved to local file: " + filePath);

            // Construct the S3 object key based on the local file name
            //String s3ObjectKey = "checksum/" + fileName + ".txt";

            // Upload the local file to S3
            // Assume you have an S3Client or use the appropriate S3 API for upload
            // For simplicity, the actual upload logic is not included here
            //uploadFileToS3(localFilePath, s3ObjectKey);

            //System.out.println("File uploaded to S3. S3 object key: " + s3ObjectKey);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log it or throw a custom exception)
        }
    }

    private static void uploadFileToS3(Path localFilePath, String s3ObjectKey) {
        // Simulated S3 upload
        // Actual S3 upload logic using an S3 client should be implemented here
        // For simplicity, we print a message indicating the upload
        System.out.println("Simulated S3 upload of file: " + localFilePath + " to key: " + s3ObjectKey);
    }

    private static String getFormattedTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return dateFormat.format(new Date());
    }
}
