This project is based on the Duke project template, which is named after the Java mascot Duke. I renamed it to GodBot, inspired by myself being a GOD coder. Below are the instructions to set up and run the project.

Setting up in Intellij
Prerequisites: JDK 17, update Intellij to the most recent version.

Open Intellij (if you are not in the welcome screen, click File > Close Project to close the existing project first)
Open the project into Intellij as follows:
Click Open.
Select the project directory, and click OK.
If there are any further prompts, accept the defaults.
Configure the project to use JDK 17 (not other versions) as explained in here.
In the same dialog, set the Project language level field to the SDK default option.
After that, locate the src/main/java/GodBot.java file, right-click it, and choose Run GodBot.main() (if the code editor is showing compile errors, try restarting the IDE).
Warning: Keep the src\main\java folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
