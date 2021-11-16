import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from "vue-router"
import vuetify from "./plugin/vuetify";
//import './plugin/bootstrap'
import './plugin/bootstrap-vue'
import App from "pages/App.vue";
import HomeMain from "./components/Home/HomeMain.vue";
import LanguageMain from "./components/Language/LanguageMain.vue";
import IntellectTrainingMain from "./components/IntellectTraining/IntellectTrainingMain.vue";
import MessageMain from "./components/Message/MessageMain.vue";
import FriendMain from "./components/Friend/FriendMain.vue";
import SettingsMain from "./components/Settings/SettingsMain.vue";
import LoginMain from "./components/Login/LoginMain.vue";
import test from "./components/Language/Kotlin/Test/test.vue";
import JavaLanguage from "./components/Language/Java/JavaLanguage.vue";
import KotlinLanguage from "./components/Language/Kotlin/KotlinLanguage.vue";
import JSLanguage from "./components/Language/JS/JSLanguage.vue";
/*Java components*/
import ProgramPlatform from "./components/Language/Java/Chapter/1Introduce/ProgramPlatform/ProgramPlatform.vue";
import History from "./components/Language/Java/Chapter/1Introduce/History/History.vue";
import Delusions from "./components/Language/Java/Chapter/1Introduce/Delusions/Delusions.vue";
//2.1
import SimpleProgramExample
    from "./components/Language/Java/Chapter/2LanguageConstruction/1SimpleProgramExample/SimpleProgramExample.vue";
//2.2
import Comments from "./components/Language/Java/Chapter/2LanguageConstruction/2Comments/Comments.vue";
//2.3
import BooleanType from "./components/Language/Java/Chapter/2LanguageConstruction/3DataTypes/Theme/BooleanType.vue";
import CharType from "./components/Language/Java/Chapter/2LanguageConstruction/3DataTypes/Theme/CharType.vue";
import FloatType from "./components/Language/Java/Chapter/2LanguageConstruction/3DataTypes/Theme/FloatType.vue";
import IntType from "./components/Language/Java/Chapter/2LanguageConstruction/3DataTypes/Theme/IntType.vue";
//2.4
import Constants from "./components/Language/Java/Chapter/2LanguageConstruction/4TempAndConstant/Theme/Constants.vue";
import EnumType from "./components/Language/Java/Chapter/2LanguageConstruction/4TempAndConstant/Theme/EnumType.vue";
import InitializeTemp
    from "./components/Language/Java/Chapter/2LanguageConstruction/4TempAndConstant/Theme/InitializeTemp.vue";
import IntroductionTemp
    from "./components/Language/Java/Chapter/2LanguageConstruction/4TempAndConstant/Theme/IntroductionTemp.vue";
//2.5
import ArithmeticOperation
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/ArithmeticOperation.vue";
import BitwiseOperation
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/BitwiseOperation.vue";
import BringingType from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/BringingType.vue";
import CombinationArithmethicOperationWithAssignment
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/CombinationArithmethicOperationWithAssignment.vue";
import IncrementAndDecrement
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/IncrementAndDecrement.vue";
import MathFunctionAndConstants
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/MathFunctionAndConstants.vue";
import RelashionshipOperationAndBoolean
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/RelashionshipOperationAndBoolean.vue";
import RoundBraceAndHierarchyOperattion
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/RoundBraceAndHierarchyOperattion.vue";
import TransformationDigitType
    from "./components/Language/Java/Chapter/2LanguageConstruction/5Operations/Theme/TransformationDigitType.vue";
//2.6
import API_Str from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/API_Str.vue";
import BuildingSymbolStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/BuildingSymbolStr.vue";
import CheckingSymbolStrOnEquality
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/CheckingSymbolStrOnEquality.vue";
import CodePointAndUnits
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/CodePointAndUnits.vue";
import ConcatinationStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/ConcatinationStr.vue";
import ConstantlySymbolStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/ConstantlySymbolStr.vue";
import EmptyZeroStr from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/EmptyZeroStr.vue";
import SubStr from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/SubStr.vue";
//2.7
import FileInputOutputData
    from "./components/Language/Java/Chapter/2LanguageConstruction/7InputAndOutput/Theme/FileInputOutputData.vue";
import FormattingOutputData
    from "./components/Language/Java/Chapter/2LanguageConstruction/7InputAndOutput/Theme/FormattingOutputData.vue";
import ReadInputData
    from "./components/Language/Java/Chapter/2LanguageConstruction/7InputAndOutput/Theme/ReadInputData.vue";
//2.8
import BreaksOperations
    from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/BreaksOperations.vue";
import ConditionalOperators
    from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/ConditionalOperators.vue";
import Cycle from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/Cycle.vue";
import PlaceVisibleBlocks
    from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/PlaceVisibleBlocks.vue";
import Switch from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/Switch.vue";
import UndefindedCycle
    from "./components/Language/Java/Chapter/2LanguageConstruction/8ManageLogic/Theme/UndefindedCycle.vue";
//2.9
import BigDigit from "./components/Language/Java/Chapter/2LanguageConstruction/9BigDigit/BigDigit.vue";
//2.10
import AccessToElement
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/AccessToElement.vue";
import CopyingMassive from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/CopyingMassive.vue";
import ForEachStyle from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/ForEachStyle.vue";
import IntroductionArray
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/IntroductionArray.vue";
import MultidimensionalMassive
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/MultidimensionalMassive.vue";
import ParamethersComandLines
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/ParamethersComandLines.vue";
import SortingMassive from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/SortingMassive.vue";
import UnevenMassive from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/UnevenMassive.vue";
//3.1
import Classes from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/Classes.vue";
import IdentificationClasses from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/IdentificationClasses.vue";
import Objects from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/Objects.vue";
import RelationBetweenClasses from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/RelationBetweenClasses.vue";
//3.2
import ConfigurationMethods
    from "./components/Language/Java/Chapter/3OOP/2TempRemakeClass/Theme/ConfigurationMethods.vue";
import LocalDate from "./components/Language/Java/Chapter/3OOP/2TempRemakeClass/Theme/LocalDate.vue";
import ObjectsAndObjectsTemp
    from "./components/Language/Java/Chapter/3OOP/2TempRemakeClass/Theme/ObjectsAndObjectsTemp.vue";
//3.3
import AnalizeClassEmployee
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/AnalizeClassEmployee.vue";
import ClassEmployee from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ClassEmployee.vue";
import ClosedMethods from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ClosedMethods.vue";
import Constructor from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/Constructor.vue";
import ExplicitAndUnexplicitParamethers
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ExplicitAndUnexplicitParamethers.vue";
import IncapsulationBenefits
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/IncapsulationBenefits.vue";
import NullLinlOnObjects
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/NullLinlOnObjects.vue";
import PrivelegeAccessToDataInClass
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/PrivelegeAccessToDataInClass.vue";
import UsesOfSeveralSoursesCode
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/UsesOfSeveralSoursesCode.vue";
import VarTemp from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/VarTemp.vue";
//3.4
import FabricMethods from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/FabricMethods.vue";
import MethodMain from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/MethodMain.vue";
import StaticConst from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/StaticConst.vue";
import StaticField from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/StaticField.vue";
import StaticMethods from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/StaticMethods.vue";
//3.6
import BlocksInitialization
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/BlocksInitialization.vue";
import Call1ConstructorFromAnother
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/Call1ConstructorFromAnother.vue";
import ConstructorWithoutArgs
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/ConstructorWithoutArgs.vue";
import DestroyObjectsAndMethodFinalize
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/DestroyObjectsAndMethodFinalize.vue";
import ExplicitInitialization
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/ExplicitInitialization.vue";
import InitializingFieldByDefoult
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/InitializingFieldByDefoult.vue";
import NameParamethers from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/NameParamethers.vue";
import Overload from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/Overload.vue";
//3.5
import ParamethrMethods from "./components/Language/Java/Chapter/3OOP/5ParamethrMethods/ParamethrMethods.vue";
//3.7
import AreaOfVisiblePacket from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/AreaOfVisiblePacket.vue";
import ImportClasses from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/ImportClasses.vue";
import IncomeClassesInPacket from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/IncomeClassesInPacket.vue";
import NamingPackets from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/NamingPackets.vue";
import PathToClasses from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/PathToClasses.vue";
import PointingPathToClass from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/PointingPathToClass.vue";
import StaticImport from "./components/Language/Java/Chapter/3OOP/7Packets/Theme/StaticImport.vue";
//3.8
import CreatingJARFiles from "./components/Language/Java/Chapter/3OOP/8ArchiveJARFiles/Theme/CreatingJARFiles.vue";
import ExetableJAR from "./components/Language/Java/Chapter/3OOP/8ArchiveJARFiles/Theme/ExetableJAR.vue";
import ManifestFile from "./components/Language/Java/Chapter/3OOP/8ArchiveJARFiles/Theme/ManifestFile.vue";
import ManyVertionArchiveFiles
    from "./components/Language/Java/Chapter/3OOP/8ArchiveJARFiles/Theme/ManyVertionArchiveFiles.vue";
//3.9
import AddingComments from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/AddingComments.vue";
import ClassComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/ClassComment.vue";
import CommonComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/CommonComment.vue";
import FieldComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/FieldComment.vue";
import MethodComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/MethodComment.vue";
import PacketComments from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/PacketComments.vue";
import RetrievalComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/RetrievalComment.vue";

import RecomendationDevelopmentClasses
    from "./components/Language/Java/Chapter/3OOP/10RecomendationDevelopmentClasses/RecomendationDevelopmentClasses.vue";
//4.1
import AbstractClasses
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/AbstractClasses.vue";
import CallingMethods
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/CallingMethods.vue";
import ConstructionUnderclasses
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/ConstructionUnderclasses.vue";
import DefenitionUnderClasses
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/DefenitionUnderClasses.vue";
import DefensiveAccess
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/DefensiveAccess.vue";
import HierarchyInheritance
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/HierarchyInheritance.vue";
import Polymorfizm
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/Polymorfizm.vue";
import PreventionInheritance
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/PreventionInheritance.vue";
import RedefenitionMethods
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/RedefenitionMethods.vue";
//4.2
import ExaminationObjectOnEqualAndInheritance
    from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/ExaminationObjectOnEqualAndInheritance.vue";
import MethodHashCode from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodHashCode.vue";
import MethodsEqual from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodsEqual.vue";
import MethodTostring from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodTostring.vue";
import TempObjectType from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/TempObjectType.vue";
//4.3
import AccessToElementLinkMassive
    from "./components/Language/Java/Chapter/4Inheritance/3ListingMassive/Theme/AccessToElementLinkMassive.vue";
import AnnouncementLinkMassive
    from "./components/Language/Java/Chapter/4Inheritance/3ListingMassive/Theme/AnnouncementLinkMassive.vue";
//4.4
import ObjectShellAndAutoPacking
    from "./components/Language/Java/Chapter/4Inheritance/4ObjectShellAndAutoPacking/ObjectShellAndAutoPacking.vue";
//4.5
import TempCountParamethersOfMethod
    from "./components/Language/Java/Chapter/4Inheritance/5TempCountParamethersOfMethod/TempCountParamethersOfMethod.vue";
//4.6
import EnumClasses from "./components/Language/Java/Chapter/4Inheritance/6EnumClasses/EnumClasses.vue";
//4.7
import AnalyzeFunctionalOprrtunityOfReflection
    from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/AnalyzeFunctionalOprrtunityOfReflection.vue";
import AnalyzeObjectOnProcessingByReflection
    from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/AnalyzeObjectOnProcessingByReflection.vue";
import BasementProccessException
    from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/BasementProccessException.vue";
import CallingMethodsAndConstructors
    from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/CallingMethodsAndConstructors.vue";
import ClassClass from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/ClassClass.vue";
import Resource from "./components/Language/Java/Chapter/4Inheritance/7Reflection/Theme/Resource.vue";
//4.8
import RecomendationUseInheritance
    from "./components/Language/Java/Chapter/4Inheritance/8RecomendationUseInheritance/RecomendationUseInheritance.vue";
//5.1
import ClonningObjects
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/ClonningObjects.vue";
import ConceptInterface
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/ConceptInterface.vue";
import InterfaceComparator
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/InterfaceComparator.vue";
import InterfacesAndAbstarctClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/InterfacesAndAbstarctClasses.vue";
import InterfacesAndBackcall
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/InterfacesAndBackcall.vue";
import MethodsWithRealizationByDefault
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/MethodsWithRealizationByDefault.vue";
import PropertiesIntefaces
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/PropertiesIntefaces.vue";
import StaticAndClosenMethods
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/1Interfaces/Theme/StaticAndClosenMethods.vue";
//5.2
import AreaOfVizabylityTemps
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/AreaOfVizabylityTemps.vue";
import FunctionalInterfaces
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/FunctionalInterfaces.vue";
import LinkToTheConstructors
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/LinkToTheConstructors.vue";
import LinkToTheMethods
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/LinkToTheMethods.vue";
import ProcessingLyambda
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/ProcessingLyambda.vue";
import ReasonsForUseLyambda
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/ReasonsForUseLyambda.vue";
import SyntaxLyambda
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/2Lyambda/Theme/SyntaxLyambda.vue";
//5.3
import AccessToConditionToInnerClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/AccessToConditionToInnerClasses.vue";
import AccessToEndedTempFromOutsideMethods
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/AccessToEndedTempFromOutsideMethods.vue";
import AnonimusInnerClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/AnonimusInnerClasses.vue";
import LocalInnerClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/LocalInnerClasses.vue";
import SpecialSyntaxRuleForInnerClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/SpecialSyntaxRuleForInnerClasses.vue";
import StaticInnerClasses
    from "./components/Language/Java/Chapter/5interfaceLyambdaAndInner/3InnerClasses/Theme/StaticInnerClasses.vue";
//6.1
import ClassificationExeption
    from "./components/Language/Java/Chapter/6Exeption/1WorkingWithExeption/Theme/ClassificationExeption.vue";
import CreationClassesExeption
    from "./components/Language/Java/Chapter/6Exeption/1WorkingWithExeption/Theme/CreationClassesExeption.vue";
import DeclarationProvedExeption
    from "./components/Language/Java/Chapter/6Exeption/1WorkingWithExeption/Theme/DeclarationProvedExeption.vue";
import OrderGenerationExeption
    from "./components/Language/Java/Chapter/6Exeption/1WorkingWithExeption/Theme/OrderGenerationExeption.vue";
//6.2
import AnalizeElementsTracestack
    from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/AnalizeElementsTracestack.vue";
import BlockFinaly from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/BlockFinaly.vue";
import InterceptionOneExeption
    from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/InterceptionOneExeption.vue";
import InterceptionSomeExeption
    from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/InterceptionSomeExeption.vue";
import OperatorTryWithResource
    from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/OperatorTryWithResource.vue";
import RegenerationAndLinkExeptionInChain
    from "./components/Language/Java/Chapter/6Exeption/2InterceptionExeption/Theme/RegenerationAndLinkExeptionInChain.vue";
//6.3
import RecomendationWorkWithExeption
    from "./components/Language/Java/Chapter/6Exeption/3RecomendationWorkWithExeption/RecomendationWorkWithExeption.vue";
//7.1
import DeclarationGeneric
    from "./components/Language/Java/Chapter/7GenericProgramming/1DeclarationGeneric/DeclarationGeneric.vue";
//7.2
import DeclarationSimpleGenericClass
    from "./components/Language/Java/Chapter/7GenericProgramming/2DeclarationSimpleGenericClass/DeclarationSimpleGenericClass.vue";
//7.3
import GenericMethods from "./components/Language/Java/Chapter/7GenericProgramming/3GenericMethods/GenericMethods.vue";
//7.4
import LimitOnGenericType
    from "./components/Language/Java/Chapter/7GenericProgramming/4LimitOnGenericType/LimitOnGenericType.vue";
//7.5
import CallingInherinceCode
    from "./components/Language/Java/Chapter/7GenericProgramming/5GenericCodeAndVirtualMachine/Theme/CallingInherinceCode.vue";
import ClearingTypes
    from "./components/Language/Java/Chapter/7GenericProgramming/5GenericCodeAndVirtualMachine/Theme/ClearingTypes.vue";
import TransformationGenericExpression
    from "./components/Language/Java/Chapter/7GenericProgramming/5GenericCodeAndVirtualMachine/Theme/TransformationGenericExpression.vue";
//7.6
import TransformationGenericMethods
    from "./components/Language/Java/Chapter/7GenericProgramming/5GenericCodeAndVirtualMachine/Theme/TransformationGenericMethods.vue";
//7.7
import RuleInhiretenceGenericType
    from "./components/Language/Java/Chapter/7GenericProgramming/7RuleInhiretenceGenericType/RuleInhiretenceGenericType.vue";
//8.1
import InterfaceCollection
    from "./components/Language/Java/Chapter/8Collections/1CarcasCollectionsInJava/Theme/InterfaceCollection.vue";
import Iterator from "./components/Language/Java/Chapter/8Collections/1CarcasCollectionsInJava/Theme/Iterator.vue";
import SeparationsInterfaces
    from "./components/Language/Java/Chapter/8Collections/1CarcasCollectionsInJava/Theme/SeparationsInterfaces.vue";
//8.2
import InterfacesInCarcasCollectionsInJava
    from "./components/Language/Java/Chapter/8Collections/2InterfacesInCarcasCollectionsInJava/InterfacesInCarcasCollectionsInJava.vue";
//8.3
import HashMap from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/HashMap.vue";
import LinkedList from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/LinkedList.vue";
import ListMassive from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/ListMassive.vue";
import OneAndTwoQuequ from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/OneAndTwoQuequ.vue";
import QuequOnPriority from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/QuequOnPriority.vue";
import TreeMap from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/TreeMap.vue";
//8.4
import EnumCollectionsAndReflection
    from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/EnumCollectionsAndReflection.vue";
import LinkHashmapAndReflection
    from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/LinkHashmapAndReflection.vue";
import OperationOnReflection
    from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/OperationOnReflection.vue";
import PerfomanceReflection
    from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/PerfomanceReflection.vue";
import UpdateRowInReflection
    from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/UpdateRowInReflection.vue";
import WeakReflection from "./components/Language/Java/Chapter/8Collections/4Reflection/Theme/WeakReflection.vue";
//8.5
import BinarySearch from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/BinarySearch.vue";
import GroupOperations from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/GroupOperations.vue";
import PerfomanceGenricAlgorithms
    from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/PerfomanceGenricAlgorithms.vue";
import RelativePerfomanceCollectionsAndArrays
    from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/RelativePerfomanceCollectionsAndArrays.vue";
import SimpleAlgorithm from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/SimpleAlgorithm.vue";
import SortingAndReplacement
    from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/SortingAndReplacement.vue";
import WriteOwnAlgorithm from "./components/Language/Java/Chapter/8Collections/5Algorithms/Theme/WriteOwnAlgorithm.vue";
//8.6
import BitMap from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/BitMap.vue";
import ClassHashtable from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/ClassHashtable.vue";
import Enums from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/Enums.vue";
import Stacks from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/Stacks.vue";
import TablesProperties
    from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/TablesProperties.vue";


//Глобальная шина событий
Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false

const routes = [
    {path: '/home', component: HomeMain},
    {path: '/language', component: LanguageMain},
    {path: '/language/java', component: JavaLanguage},
    /*Java paths*/
    //1 chapter
    {path: '/language/java/introduceinjava/programplatform', component: ProgramPlatform},
    {path: '/language/java/introduceinjava/history', component: History},
    {path: '/language/java/introduceinjava/delusions', component: Delusions},

    //2 chapter
    //2.1
    {path: '/language/java/languageconstruction/simpleprogramexample', component: SimpleProgramExample},
    //2.2
    {path: '/language/java/languageconstruction/comments', component: Comments},

    //2.3
    {path: '/language/java/languageconstruction/datatype/boolean', component: BooleanType},
    {path: '/language/java/languageconstruction/datatype/char', component: CharType},
    {path: '/language/java/languageconstruction/datatype/float', component: FloatType},
    {path: '/language/java/languageconstruction/datatype/int', component: IntType},

    //2.4
    {path: '/language/java/languageconstruction/themeandconstant/constants', component: Constants},
    {path: '/language/java/languageconstruction/themeandconstant/enum', component: EnumType},
    {path: '/language/java/languageconstruction/themeandconstant/initializetemp', component: InitializeTemp},
    {path: '/language/java/languageconstruction/themeandconstant/introductiontemp', component: IntroductionTemp},

    //2.5
    {path: '/language/java/languageconstruction/operations/arithmeticoperation', component: ArithmeticOperation},
    {path: '/language/java/languageconstruction/operations/bitwise', component: BitwiseOperation},
    {path: '/language/java/languageconstruction/operations/bringingtype', component: BringingType},
    {
        path: '/language/java/languageconstruction/operations/combinationarithmetoper',
        component: CombinationArithmethicOperationWithAssignment
    },
    {path: '/language/java/languageconstruction/operations/incrementdecrement', component: IncrementAndDecrement},
    {path: '/language/java/languageconstruction/operations/mathfunction', component: MathFunctionAndConstants},
    {
        path: '/language/java/languageconstruction/operations/relationshionshipoperation',
        component: RelashionshipOperationAndBoolean
    },
    {
        path: '/language/java/languageconstruction/operations/hierarchyoperation',
        component: RoundBraceAndHierarchyOperattion
    },
    {
        path: '/language/java/languageconstruction/operations/transformationdigittype',
        component: TransformationDigitType
    },

    //2.6
    {path: '/language/java/languageconstruction/symbol/apistr', component: API_Str},
    {path: '/language/java/languageconstruction/symbol/buildingstr', component: BuildingSymbolStr},
    {path: '/language/java/languageconstruction/symbol/checkingsymbolequality', component: CheckingSymbolStrOnEquality},
    {path: '/language/java/languageconstruction/symbol/codepoint', component: CodePointAndUnits},
    {path: '/language/java/languageconstruction/symbol/concatinationstr', component: ConcatinationStr},
    {path: '/language/java/languageconstruction/symbol/constantlysymbolstr', component: ConstantlySymbolStr},
    {path: '/language/java/languageconstruction/symbol/emptyzerostr', component: EmptyZeroStr},
    {path: '/language/java/languageconstruction/symbol/substr', component: SubStr},

    //2.7
    {path: '/language/java/languageconstruction/inputoutput/fileoutputdata', component: FileInputOutputData},
    {path: '/language/java/languageconstruction/inputoutput/formattingoutputdata', component: FormattingOutputData},
    {path: '/language/java/languageconstruction/inputoutput/readinputdata', component: ReadInputData},

    //2.8
    {path: '/language/java/languageconstruction/managelogic/breaksoperation', component: BreaksOperations},
    {path: '/language/java/languageconstruction/managelogic/conditionaloperators', component: ConditionalOperators},
    {path: '/language/java/languageconstruction/managelogic/cycle', component: Cycle},
    {path: '/language/java/languageconstruction/managelogic/placevisibleblock', component: PlaceVisibleBlocks},
    {path: '/language/java/languageconstruction/managelogic/switch', component: Switch},
    {path: '/language/java/languageconstruction/managelogic/undefindedcycle', component: UndefindedCycle},

    //2.9
    {path: '/language/java/languageconstruction/bigdigit', component: BigDigit},

    //2.10
    {path: '/language/java/languageconstruction/arrays/accesstoelement', component: AccessToElement},
    {path: '/language/java/languageconstruction/arrays/copymassive', component: CopyingMassive},
    {path: '/language/java/languageconstruction/arrays/foreach', component: ForEachStyle},
    {path: '/language/java/languageconstruction/arrays/introductionarray', component: IntroductionArray},
    {path: '/language/java/languageconstruction/arrays/multidimentionalmassive', component: MultidimensionalMassive},
    {path: '/language/java/languageconstruction/arrays/parametherscmd', component: ParamethersComandLines},
    {path: '/language/java/languageconstruction/arrays/sortingmassive', component: SortingMassive},
    {path: '/language/java/languageconstruction/arrays/unevenmassive', component: UnevenMassive},

    //3.1
    {path: '/language/java/oop/intro/classes', component: Classes},
    {path: '/language/java/oop/intro/identificationClasses', component: IdentificationClasses},
    {path: '/language/java/oop/intro/objects', component: Objects},
    {path: '/language/java/oop/intro/relationclasses', component: RelationBetweenClasses},

    //3.2
    {path: '/language/java/oop/tempremake/configurationmethod', component: ConfigurationMethods},
    {path: '/language/java/oop/tempremake/localdate', component: LocalDate},
    {path: '/language/java/oop/tempremake/objectsandobjectstemp', component: ObjectsAndObjectsTemp},

    //3.3
    {path: '/language/java/oop/defindingownclasses/AnalizeClassEmployee', component: AnalizeClassEmployee},
    {path: '/language/java/oop/defindingownclasses/classyemployee', component: ClassEmployee},
    {path: '/language/java/oop/defindingownclasses/closedMethods', component: ClosedMethods},
    {path: '/language/java/oop/defindingownclasses/constructor', component: Constructor},
    {path: '/language/java/oop/defindingownclasses/EndedField', component: AnalizeClassEmployee},
    {
        path: '/language/java/oop/defindingownclasses/ExplicitAndUnexplicitParamethers',
        component: ExplicitAndUnexplicitParamethers
    },
    {path: '/language/java/oop/defindingownclasses/incapsulationBenefits', component: IncapsulationBenefits},
    {path: '/language/java/oop/defindingownclasses/NullLinlOnObjects', component: NullLinlOnObjects},
    {
        path: '/language/java/oop/defindingownclasses/PrivelegeAccessToDataInClass',
        component: PrivelegeAccessToDataInClass
    },
    {path: '/language/java/oop/defindingownclasses/UsesOfSeveralSoursesCode', component: UsesOfSeveralSoursesCode},
    {path: '/language/java/oop/defindingownclasses/VarTemp', component: VarTemp},

    //3.4
    {path: '/language/java/oop/staticField/FabricMethods', component: FabricMethods},
    {path: '/language/java/oop/staticField/MethodMain', component: MethodMain},
    {path: '/language/java/oop/staticField/StaticConst', component: StaticConst},
    {path: '/language/java/oop/staticField/StaticField', component: StaticField},
    {path: '/language/java/oop/staticField/StaticMethods', component: StaticMethods},

    //3.5
    {path: '/language/java/oop/paramethrMethods', component: ParamethrMethods},

    //3.6
    {path: '/language/java/oop/constructionObject/BlocksInitialization', component: BlocksInitialization},
    {path: '/language/java/oop/constructionObject/Call1ConstructorFromAnother', component: Call1ConstructorFromAnother},
    {path: '/language/java/oop/constructionObject/ConstructorWithoutArgs', component: ConstructorWithoutArgs},
    {
        path: '/language/java/oop/constructionObject/DestroyObjectsAndMethodFinalize',
        component: DestroyObjectsAndMethodFinalize
    },
    {path: '/language/java/oop/constructionObject/ExplicitInitialization', component: ExplicitInitialization},
    {path: '/language/java/oop/constructionObject/InitializingFieldByDefoult', component: InitializingFieldByDefoult},
    {path: '/language/java/oop/constructionObject/NameParamethers', component: NameParamethers},
    {path: '/language/java/oop/constructionObject/Overload', component: Overload},

    //3.7
    {path: '/language/java/oop/pocket/AreaOfVisiblePacket', component: AreaOfVisiblePacket},
    {path: '/language/java/oop/pocket/ImportClasses', component: ImportClasses},
    {path: '/language/java/oop/pocket/IncomeClassesInPacket', component: IncomeClassesInPacket},
    {path: '/language/java/oop/pocket/NamingPackets', component: NamingPackets},
    {path: '/language/java/oop/pocket/PathToClasses', component: PathToClasses},
    {path: '/language/java/oop/pocket/PointingPathToClass', component: PointingPathToClass},
    {path: '/language/java/oop/pocket/StaticImport', component: StaticImport},

    //3.8
    {path: '/language/java/oop/archiveJARFiles/CreatingJARFiles', component: CreatingJARFiles},
    {path: '/language/java/oop/archiveJARFiles/ExetableJAR', component: ExetableJAR},
    {path: '/language/java/oop/archiveJARFiles/ManifestFile', component: ManifestFile},
    {path: '/language/java/oop/archiveJARFiles/ManyVertionArchiveFiles', component: ManyVertionArchiveFiles},

    //3.9
    {path: '/language/java/oop/comments/AddingComments', component: AddingComments},
    {path: '/language/java/oop/comments/ClassComment', component: ClassComment},
    {path: '/language/java/oop/comments/CommonComment', component: CommonComment},
    {path: '/language/java/oop/comments/FieldComment', component: FieldComment},
    {path: '/language/java/oop/comments/MethodComment', component: MethodComment},
    {path: '/language/java/oop/comments/PacketComments', component: PacketComments},
    {path: '/language/java/oop/comments/RetrievalComment', component: RetrievalComment},

    //3.10
    {path: '/language/java/oop/RecomendationDevelopmentClasses', component: RecomendationDevelopmentClasses},

    //4.1
    {path: '/language/java/inheritance/AbstractClasses', component: AbstractClasses},
    {path: '/language/java/inheritance/BringingTypes', component: BringingType},
    {path: '/language/java/inheritance/CallingMethods', component: CallingMethods},
    {path: '/language/java/inheritance/ConstructionUnderclasses', component: ConstructionUnderclasses},
    {path: '/language/java/inheritance/DefenitionUnderClasses', component: DefenitionUnderClasses},
    {path: '/language/java/inheritance/DefensiveAccess', component: DefensiveAccess},
    {path: '/language/java/inheritance/HierarchyInheritance', component: HierarchyInheritance},
    {path: '/language/java/inheritance/Polymorfizm', component: Polymorfizm},
    {path: '/language/java/inheritance/PreventionInheritance', component: PreventionInheritance},
    {path: '/language/java/inheritance/RedefenitionMethods', component: RedefenitionMethods},

    //4.2
    {
        path: '/language/java/inheritance/ExaminationObjectOnEqualAndInheritance',
        component: ExaminationObjectOnEqualAndInheritance
    },
    {path: '/language/java/inheritance/MethodHashCode', component: MethodHashCode},
    {path: '/language/java/inheritance/MethodsEqual', component: MethodsEqual},
    {path: '/language/java/inheritance/MethodTostring', component: MethodTostring},
    {path: '/language/java/inheritance/TempObjectType', component: TempObjectType},

    //4.3
    {path: '/language/java/inheritance/AccessToElementLinkMassive', component: AccessToElementLinkMassive},
    {path: '/language/java/inheritance/AnnouncementLinkMassive', component: AnnouncementLinkMassive},

    //4.4
    {path: '/language/java/inheritance/ObjectShellAndAutoPacking', component: ObjectShellAndAutoPacking},

    //4.5
    {path: '/language/java/inheritance/TempCountParamethersOfMethod', component: TempCountParamethersOfMethod},

    //4.6
    {path: '/language/java/inheritance/EnumClasses', component: EnumClasses},

    //4.7
    {
        path: '/language/java/inheritance/AnalyzeFunctionalOprrtunityOfReflection',
        component: AnalyzeFunctionalOprrtunityOfReflection
    },
    {
        path: '/language/java/inheritance/AnalyzeObjectOnProcessingByReflection',
        component: AnalyzeObjectOnProcessingByReflection
    },
    {path: '/language/java/inheritance/BasementProccessException', component: BasementProccessException},
    {path: '/language/java/inheritance/CallingMethodsAndConstructors', component: CallingMethodsAndConstructors},
    {path: '/language/java/inheritance/ClassClass', component: ClassClass},
    {path: '/language/java/inheritance/Resource', component: Resource},

    //4.8
    {path: '/language/java/inheritance/RecomendationUseInheritance', component: RecomendationUseInheritance},

    //5.1
    {path: '/language/java/interfacesLyambdaAndInner/ClonningObjects', component: ClonningObjects},
    {path: '/language/java/interfacesLyambdaAndInner/ConceptInterface', component: ConceptInterface},
    {path: '/language/java/interfacesLyambdaAndInner/InterfaceComparator', component: InterfaceComparator},
    {
        path: '/language/java/interfacesLyambdaAndInner/InterfacesAndAbstarctClasses',
        component: InterfacesAndAbstarctClasses
    },
    {path: '/language/java/interfacesLyambdaAndInner/InterfacesAndBackcall', component: InterfacesAndBackcall},
    {
        path: '/language/java/interfacesLyambdaAndInner/MethodsWithRealizationByDefault',
        component: MethodsWithRealizationByDefault
    },
    {path: '/language/java/interfacesLyambdaAndInner/PropertiesIntefaces', component: PropertiesIntefaces},
    {path: '/language/java/interfacesLyambdaAndInner/StaticAndClosenMethods', component: StaticAndClosenMethods},

    //5.2
    {path: '/language/java/interfacesLyambdaAndInner/AreaOfVizabylityTemps', component: AreaOfVizabylityTemps},
    {path: '/language/java/interfacesLyambdaAndInner/FunctionalInterfaces', component: FunctionalInterfaces},
    {path: '/language/java/interfacesLyambdaAndInner/LinkToTheConstructors', component: LinkToTheConstructors},
    {path: '/language/java/interfacesLyambdaAndInner/LinkToTheMethods', component: LinkToTheMethods},
    {path: '/language/java/interfacesLyambdaAndInner/ProcessingLyambda', component: ProcessingLyambda},
    {path: '/language/java/interfacesLyambdaAndInner/ReasonsForUseLyambda', component: ReasonsForUseLyambda},
    {path: '/language/java/interfacesLyambdaAndInner/SyntaxLyambda', component: SyntaxLyambda},

    //5.3
    {
        path: '/language/java/interfacesLyambdaAndInner/AccessToConditionToInnerClasses',
        component: AccessToConditionToInnerClasses
    },
    {
        path: '/language/java/interfacesLyambdaAndInner/AccessToEndedTempFromOutsideMethods',
        component: AccessToEndedTempFromOutsideMethods
    },
    {path: '/language/java/interfacesLyambdaAndInner/AnonimusInnerClasses', component: AnonimusInnerClasses},
    {path: '/language/java/interfacesLyambdaAndInner/LocalInnerClasses', component: LocalInnerClasses},
    {
        path: '/language/java/interfacesLyambdaAndInner/SpecialSyntaxRuleForInnerClasses',
        component: SpecialSyntaxRuleForInnerClasses
    },
    {path: '/language/java/interfacesLyambdaAndInner/StaticInnerClasses', component: StaticInnerClasses},

    //6.1
    {path: '/language/java/exeption/ClassificationExeption', component: ClassificationExeption},
    {path: '/language/java/exeption/CreationClassesExeption', component: CreationClassesExeption},
    {path: '/language/java/exeption/DeclarationProvedExeption', component: DeclarationProvedExeption},
    {path: '/language/java/exeption/OrderGenerationExeption', component: OrderGenerationExeption},

    //6.2
    {path: '/language/java/exeption/AnalizeElementsTracestack', component: AnalizeElementsTracestack},
    {path: '/language/java/exeption/BlockFinaly', component: BlockFinaly},
    {path: '/language/java/exeption/InterceptionOneExeption', component: InterceptionOneExeption},
    {path: '/language/java/exeption/InterceptionSomeExeption', component: InterceptionSomeExeption},
    {path: '/language/java/exeption/OperatorTryWithResource', component: OperatorTryWithResource},
    {path: '/language/java/exeption/RegenerationAndLinkExeptionInChain', component: RegenerationAndLinkExeptionInChain},

    //6.3
    {path: '/language/java/exeption/RecomendationWorkWithExeption', component: RecomendationWorkWithExeption},

    //7.1
    {path: '/language/java/generics/DeclarationGeneric', component: DeclarationGeneric},

    //7.2
    {path: '/language/java/generics/DeclarationSimpleGenericClass', component: DeclarationSimpleGenericClass},

    //7.3
    {path: '/language/java/generics/GenericMethods', component: GenericMethods},

    //7.4
    {path: '/language/java/generics/LimitOnGenericType', component: LimitOnGenericType},

    //7.5
    {path: '/language/java/generics/CallingInherinceCode', component: CallingInherinceCode},
    {path: '/language/java/generics/ClearingTypes', component: ClearingTypes},
    {path: '/language/java/generics/TransformationGenericExpression', component: TransformationGenericExpression},
    {path: '/language/java/generics/TransformationGenericMethods', component: TransformationGenericMethods},

    //7.6
    {path: '/language/java/generics/TransformationGenericMethods', component: TransformationGenericMethods},

    //7.7
    {path: '/language/java/generics/RuleInhiretenceGenericType', component: RuleInhiretenceGenericType},

    //8.1
    {path: '/language/java/collections/InterfaceCollection', component: InterfaceCollection},
    {path: '/language/java/collections/Iterator', component: Iterator},
    {path: '/language/java/collections/SeparationsInterfaces', component: SeparationsInterfaces},

    //8.2
    {path: '/language/java/collections/InterfacesInCarcasCollectionsInJava', component: InterfacesInCarcasCollectionsInJava},

    //8.3
    {path: '/language/java/collections/HashMap', component: HashMap},
    {path: '/language/java/collections/LinkedList', component: LinkedList},
    {path: '/language/java/collections/ListMassive', component: ListMassive},
    {path: '/language/java/collections/OneAndTwoQuequ', component: OneAndTwoQuequ},
    {path: '/language/java/collections/QuequOnPriority', component: QuequOnPriority},
    {path: '/language/java/collections/TreeMap', component: TreeMap},

    //8.4
    {path: '/language/java/collections/EnumCollectionsAndReflection', component: EnumCollectionsAndReflection},
    {path: '/language/java/collections/LinkHashmapAndReflection', component: LinkHashmapAndReflection},
    {path: '/language/java/collections/OperationOnReflection', component: OperationOnReflection},
    {path: '/language/java/collections/PerfomanceReflection', component: PerfomanceReflection},
    {path: '/language/java/collections/UpdateRowInReflection', component: UpdateRowInReflection},
    {path: '/language/java/collections/WeakReflection', component: WeakReflection},

    //8.5
    {path: '/language/java/collections/BinarySearch', component: BinarySearch},
    {path: '/language/java/collections/GroupOperations', component: GroupOperations},
    {path: '/language/java/collections/PerfomanceGenricAlgorithms', component: PerfomanceGenricAlgorithms},
    {path: '/language/java/collections/RelativePerfomanceCollectionsAndArrays', component: RelativePerfomanceCollectionsAndArrays},
    {path: '/language/java/collections/SimpleAlgorithm', component: SimpleAlgorithm},
    {path: '/language/java/collections/SortingAndReplacement', component: SortingAndReplacement},
    {path: '/language/java/collections/WriteOwnAlgorithm', component: WriteOwnAlgorithm},

    //8.6
    {path: '/language/java/collections/BitMap', component: BitMap},
    {path: '/language/java/collections/ClassHashtable', component: ClassHashtable},
    {path: '/language/java/collections/Enums', component: Enums},
    {path: '/language/java/collections/Stacks', component: Stacks},
    {path: '/language/java/collections/TablesProperties', component: TablesProperties},

    {path: '/language/kotlin', component: KotlinLanguage},
    {path: '/language/js', component: JSLanguage},

    //test
    {path: '/language/kotlin/1', component: test},

    {path: '/intellecttraining', component: IntellectTrainingMain},
    {path: '/message', component: MessageMain},
    {path: '/friend', component: FriendMain},
    {path: '/settings', component: SettingsMain},
    {path: '/login', component: LoginMain},
    //{path: '/registration', component: Registration}
]

const router = new VueRouter({
    routes
})

new Vue({
    router,
    vuetify,
    render: h => h(App),
}).$mount('#app')
