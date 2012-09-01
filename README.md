FlaAntTask
==========

Ant task that runs an embedded jsfl script to publish flas

<project name="FlaAntTask" basedir="." default="use">
  
	<target name="use" description="Use the Task">
		
    <taskdef name="fla" classname="shmedia.utils.FlaAntTask" classpath="${ant.project.name}.jar"/>
	   	
    <fla folder="${basedir}" />
	
  </target>
	
</project>