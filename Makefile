C = javac

processor:
	$(C) TheProcessor.java

import:
	$(C) -proc:only -sourcepath . -processorpath . -processor TheProcessor Import.java

static-import:
	$(C) -proc:only -sourcepath . -processorpath . -processor TheProcessor StaticImport.java
