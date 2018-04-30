# Processing 3 Eclipse template

Small template to get Processing 3 quickly up and running in Eclipse. It has:
* utilities for color management in Eclipse
* extended support for PDF printing (blend modes, default paper sizes).


## Quick install 

*(Requires bash, git, wget and unzip)*

```bash
$ wget -q https://raw.githubusercontent.com/cleverfranke/processing3-eclipse-template/master/setup.sh && bash setup.sh MyProjectName my-project-dir 
```

Then from Eclipse choose 'File' > 'Import' > 'Existing projects into Workspace' and
select my-project-dir


## Manual installation

* Clone or download the source
* Change 'Processing3EclipseTemplate' in .project to your desired project name
* Initialize new git (if you want to)
* Then from Eclipse choose 'File' > 'Import' > 'Existing projects into Workspace' and select my-project-dir

### Libraries

These libraries are currently supplied in this structure. Below gives specific
information on the versions and what additional arguments might need to be supplied 
to use them with a runnable jar.

#### Processing core libraries

Version: 3.3.7  
Website: http://processing.org

* core
* dxf
* net
* pdf
* serial
* svg

#### Contributed libraries

##### Video (/lib/processing)

Version: 1.0.1  
Website: https://processing.org/reference/libraries/video/index.html
