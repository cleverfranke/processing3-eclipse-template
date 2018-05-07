# Processing 3 Eclipse template

Small template to get Processing 3 quickly up and running in Eclipse. It has:
* utilities for color management in Eclipse
* extended support for PDF printing (blend modes, default paper sizes).


## Quick install of project

*(Requires bash, git, wget and unzip)*

```bash
$ wget -q https://raw.githubusercontent.com/cleverfranke/processing3-eclipse-template/master/setup.sh && bash setup.sh MyProjectName my-project-dir 
```

Then from Eclipse choose 'File' > 'Import' > 'Existing projects into Workspace' and
select my-project-dir


## Manual installation of project

* Clone or download the source
* Change 'Processing3EclipseTemplate' in .project to your desired project name
* Initialize new git (if you want to)
* Then from Eclipse choose 'File' > 'Import' > 'Existing projects into Workspace' and select my-project-dir

## Building an application

After developing your application, you might want to build it so you can deploy it to your target
machines. To help with that, we've included two [Ant](https://ant.apache.org/) build files: 
*build.xml* and *build-examples.xml*. 

**build.xml**
build.xml is a template file you can use to make a build file for your application. This enables you to
make repeatable deploy packages. The build file will generate a runnable jar (with all other libraries 
extracted in that jar), package all the required native libraries together with run.bat and run.sh scripts
that automatically run the jar with the correct library paths. All of this is bundled in the /dist folder.

The things you need to adjust in the build file is the name of the main class you want to be runnable 
(property name is *class.main*) and the name of the app (property name is *target*).

**build-examples.xml**
build-examples.xml is a build file that builds some relevant examples into the /dist folder together
with the required native libraries and runnable scripts.

## Included libraries

These libraries are currently supplied in this structure. Below gives specific
information on the versions and what additional arguments might need to be supplied 
to use them with a runnable jar.

### Processing core libraries

Version: 3.3.7  
Website: http://processing.org

* core
* dxf
* net
* pdf
* serial
* svg

### Contributed libraries

#### Video (/lib/processing)

Version: 1.0.1  
Website: https://processing.org/reference/libraries/video/index.html

### Adding new libraries

If you want to add more libraries to this template, place them in the /lib folder under the correct
path, so /lib/processing/{libraryName} for Processing native and contributed libraries, or 
lib/{libraryName}. Include the library in the build path and if needed (e.g. if the library requires
native libraries) make sure the Ant build files copy the required libraries and have the run scripts
reference them.
