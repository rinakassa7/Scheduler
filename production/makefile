CMD = java
COMPILE = javac

begin:
	mkdir classes && mkdir classes/tests && mkdir classes/java

compile:
	@echo "-------------------------------------------------------------------------"
	@echo "compilation des classes fil rouge..."
	@echo "-------------------------------------------------------------------------"
	cd ../fil_rouge/application && $(COMPILE) -cp ../../production/jar/scheduleio.jar fil_rouge/*.java -d ../../production/classes/java
	cp -rf classes/java/fil_rouge classes/tests

compile-tests:
	@echo "-------------------------------------------------------------------------"
	@echo "compilation des classes de tests..."
	@echo "-------------------------------------------------------------------------"
	cd ../fil_rouge/application && $(COMPILE) -cp ../../production/jar/hamcrest-core-1.3.jar:../../production/jar/junit-4.13-rc-1.jar:. test/*.java -d ../../production/classes/tests

start:
	@echo "-------------------------------------------------------------------------"
	@echo "lancement de l'application..."
	@echo "-------------------------------------------------------------------------"
	cd ../fil_rouge/application && $(CMD) -cp ../../production/classes/java:../../production/jar/scheduleio.jar fil_rouge.MainReader

start-tests:
	@echo "-------------------------------------------------------------------------"
	@echo "lancement des tests unitaires..."
	@echo "-------------------------------------------------------------------------"
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.PrecedenceConstraintTest
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.MaxSpanTest
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.MeetConstraintTest
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.PrecedenceConstraintWithGapTest
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.RandomSchedTest
	cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.VerifierTest

	#cd classes/tests && $(CMD) -cp .:../../jar/hamcrest-core-1.3.jar:../../jar/junit-4.13-rc-1.jar org.junit.runner.JUnitCore test.MeetConstraintTest

pipeline: delete begin compile compile-tests start-tests start

clean:
	rm -r classes/java/*
	rm -r classes/tests/*

delete:
	rm -rf classes
