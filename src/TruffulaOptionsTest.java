import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }



  @Test
  void testInvalidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "doesNotExist");
    // directory.mkdir(); not created
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
  

    // Assert: Check that the root directory is set correctly
   assertThrows(FileNotFoundException.class, () -> {
    new TruffulaOptions(args);
   });
  }

  
  @Test
  void testNoArgumentsAtAll(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    
    // directory.mkdir(); not created
    
    String[] args = {};

    // Act: Create TruffulaOptions instance
  

    // Assert: Check that the root directory is set correctly
   assertThrows(IllegalArgumentException.class, () -> {
    new TruffulaOptions(args);
   });
  }

  @Test
  void testflagsReverseOrder(@TempDir File tempDir) throws FileNotFoundException {

     File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-h", "-nc", directoryPath};

    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());

 }


 @Test

 void testUnknownFlagThrowsIllegalArgumentException(@TempDir File tempDir) {
  String[] args = {"-x", tempDir.getAbsolutePath()};

  assertThrows(IllegalArgumentException.class, () -> {
    new TruffulaOptions(args);

  });
 }

 @Test
 void testDefaultsWithOnlyDirectory(@TempDir File tempDir) throws FileNotFoundException {
  String[] args = {tempDir.getAbsolutePath()};

  TruffulaOptions options = new TruffulaOptions(args);
  assertTrue(options.isUseColor());
  assertFalse(options.isShowHidden());
 }

}
