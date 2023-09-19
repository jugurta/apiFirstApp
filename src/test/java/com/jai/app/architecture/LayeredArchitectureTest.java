package com.jai.app.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.jai.app", importOptions = ImportOption.DoNotIncludeTests.class)
class LayeredArchitectureTest {


    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture().consideringAllDependencies()

            .layer("Controllers").definedBy("com.jai.app.application.rest..")
            .layer("UseCase").definedBy("com.jai.app.usecase..")
            .layer("Infrastucture").definedBy("com.jai.app.infrastructure..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Infrastucture").mayNotBeAccessedByAnyLayer();

}
