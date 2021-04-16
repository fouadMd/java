TEST_CLS = $(PACK).VehicleTest $(PACK).RentalAgencyTest $(PACK).BrandFilterTest $(PACK).ClientTest $(PACK).MaxPriceFilterTest $(PACK).CarTest $(PACK).MotorbikeTest $(PACK).SuspiciousRentalAgencyTest
PACK = rental
MANIFEST1 = manifest-agency
MANIFEST2 = manifest-heritage
MAIN_CLS1 = RentalAgencyMain
MAIN_CLS2 = HeritageAgencyMain

all: classes/$(PACK)/*.class

classes/$(PACK)/*.class: src/$(PACK)/*.java
	mkdir classes; cd src; \
	javac $(PACK)/*.java -d ../classes;\

test: test/$(PACK)/*.class
	java -jar test-1.7.jar $(TEST_CLS)

test/$(PACK)/*.class: test/$(PACK)/*.java classes/$(PACK)/*.class
	javac -classpath test-1.7.jar test/$(PACK)/*.java

jar1: classes/$(PACK)/*.class
	cd classes; jar cvfm ../appli.jar ../$(MANIFEST1) $(PACK); \
	cd ..; java -jar appli.jar $(args)

jar2: classes/$(PACK)/*.class
	cd classes; jar cvfm ../appli.jar ../$(MANIFEST2) $(PACK); \
	cd ..; java -jar appli.jar $(args)

run1: classes/$(PACK)/*.class
	java -classpath classes $(PACK).$(MAIN_CLS1) $(args)

run2: classes/$(PACK)/*.class
	java -classpath classes $(PACK).$(MAIN_CLS2) $(args)

doc:
	cd src; javadoc -d ../docs -subpackages $(PACK)

clean:
	rm -f test/$(PACK)/*.class appli.jar -r classes docs
