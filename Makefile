JAVAC  = javac
JAVA   = java
SRC_DIR = datacounter
OUT_DIR = build
PACKAGE = inverno1718

SOURCES = $(wildcard $(SRC_DIR)/*.java)

.PHONY: all build test run clean

all: build

build:
	@mkdir -p $(OUT_DIR)/$(PACKAGE)
	@cp $(SRC_DIR)/*.java $(OUT_DIR)/$(PACKAGE)/
	$(JAVAC) -d $(OUT_DIR) $(OUT_DIR)/$(PACKAGE)/*.java
	@rm $(OUT_DIR)/$(PACKAGE)/*.java

test: build
	@cp test0.txt test1.txt $(OUT_DIR)/ 2>/dev/null || true
	cd $(OUT_DIR) && $(JAVA) $(PACKAGE).Test

run: test

clean:
	rm -rf $(OUT_DIR)
