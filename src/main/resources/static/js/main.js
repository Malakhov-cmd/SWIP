import Vue from 'vue'
import VueRouter from "vue-router"
import vuetify from "./plugin/vuetify";

import './plugin/bootstrap-vue'
import App from "pages/App.vue";
import InfoMain from "./components/Info/InfoMain.vue";
import LanguageMain from "./components/Language/LanguageMain.vue";
import HomeMain from "./components/Home/HomeMain.vue";
import AnotherUserPage from "./components/Home/AnotherUserPage.vue"
import MessageMain from "./components/Message/MessageMain.vue";
import Dialog from "./components/Message/Dialog.vue"
import FriendMain from "./components/Friend/FriendMain.vue";
import SettingsMain from "./components/Settings/SettingsMain.vue";
import LoginMain from "./components/Login/LoginMain.vue";
import test from "./components/Language/Kotlin/Test/test.vue";
/*Languages*/
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
import BuildingSymbolStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/BuildingSymbolStr.vue";
import CheckingSymbolStrOnEquality
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/CheckingSymbolStrOnEquality.vue";
import ConcatinationStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/ConcatinationStr.vue";
import ConstantlySymbolStr
    from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/ConstantlySymbolStr.vue";
import SubStr from "./components/Language/Java/Chapter/2LanguageConstruction/6SymbolStr/Theme/SubStr.vue";
//2.7
import FileInputOutputData
    from "./components/Language/Java/Chapter/2LanguageConstruction/7InputAndOutput/Theme/FileInputOutputData.vue";
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

import CopyingMassive from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/CopyingMassive.vue";
import ForEachStyle from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/ForEachStyle.vue";
import IntroductionArray
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/IntroductionArray.vue";
import MultidimensionalMassive
    from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/MultidimensionalMassive.vue";

import SortingMassive from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/SortingMassive.vue";
//3.1
import Classes from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/Classes.vue";
import IdentificationClasses from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/IdentificationClasses.vue";
import Objects from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/Objects.vue";
import RelationBetweenClasses from "./components/Language/Java/Chapter/3OOP/1IntroOOP/Theme/RelationBetweenClasses.vue";
//3.2
import LocalDate from "./components/Language/Java/Chapter/3OOP/2TempRemakeClass/Theme/LocalDate.vue";
import ObjectsAndObjectsTemp
    from "./components/Language/Java/Chapter/3OOP/2TempRemakeClass/Theme/ObjectsAndObjectsTemp.vue";
//3.3
import ClassEmployee from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ClassEmployee.vue";
import ClosedMethods from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ClosedMethods.vue";
import Constructor from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/Constructor.vue";
import ExplicitAndUnexplicitParamethers
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/ExplicitAndUnexplicitParamethers.vue";
import IncapsulationBenefits
    from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/IncapsulationBenefits.vue";
import EndedFildCopy from "./components/Language/Java/Chapter/3OOP/3DefindingOwnClasses/Theme/EndedFildCopy.vue"
//3.4
import FabricMethods from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/FabricMethods.vue";
import MethodMain from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/MethodMain.vue";
import StaticField from "./components/Language/Java/Chapter/3OOP/4StaticFieldAndMethod/Theme/StaticField.vue";
//3.6
import BlocksInitialization
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/BlocksInitialization.vue";
import ConstructorWithoutArgs
    from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/ConstructorWithoutArgs.vue";
import Overload from "./components/Language/Java/Chapter/3OOP/6ConstructionObject/Theme/Overload.vue";
//3.5
import ParamethrMethods from "./components/Language/Java/Chapter/3OOP/5ParamethrMethods/ParamethrMethods.vue";
//3.7
import Packets from "./components/Language/Java/Chapter/3OOP/7Packets/Packets.vue"
//3.8

//3.9
import AddingComments from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/AddingComments.vue";
import ClassComment from "./components/Language/Java/Chapter/3OOP/9DocumentringComments/Theme/ClassComment.vue";
//3.10
import RecomendationDevelopmentClasses
    from "./components/Language/Java/Chapter/3OOP/10RecomendationDevelopmentClasses/RecomendationDevelopmentClasses.vue";
//4.1
import AbstractClasses
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/AbstractClasses.vue";
import DefenitionUnderClasses
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/DefenitionUnderClasses.vue";
import HierarchyInheritance
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/HierarchyInheritance.vue";
import Polymorfizm
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/Polymorfizm.vue";
import PreventionInheritance
    from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/PreventionInheritance.vue";
import BringingTypes from "./components/Language/Java/Chapter/4Inheritance/1ClassesSuperClassesAndUnderClasses/Theme/BringingTypes.vue"
//4.2
import ExaminationObjectOnEqualAndInheritance
    from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/ExaminationObjectOnEqualAndInheritance.vue";
import MethodHashCode from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodHashCode.vue";
import MethodsEqual from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodsEqual.vue";
import MethodTostring from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/MethodTostring.vue";
import TempObjectType from "./components/Language/Java/Chapter/4Inheritance/2ClassObject/Theme/TempObjectType.vue";
//4.3

//4.4
import ObjectShellAndAutoPacking
    from "./components/Language/Java/Chapter/4Inheritance/4ObjectShellAndAutoPacking/ObjectShellAndAutoPacking.vue";
//4.5
import TempCountParamethersOfMethod
    from "./components/Language/Java/Chapter/4Inheritance/5TempCountParamethersOfMethod/TempCountParamethersOfMethod.vue";
//4.6
import EnumClasses from "./components/Language/Java/Chapter/4Inheritance/6EnumClasses/EnumClasses.vue";
//4.7

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
import QuequOnPriority
    from "./components/Language/Java/Chapter/8Collections/3TypeCollections/Theme/QuequOnPriority.vue";
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
import ClassHashtable
    from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/ClassHashtable.vue";
import Enums from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/Enums.vue";
import Stacks from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/Stacks.vue";
import TablesProperties
    from "./components/Language/Java/Chapter/8Collections/6InherinceCollections/Theme/TablesProperties.vue";
//9.1
import DeclarationThread from "./components/Language/Java/Chapter/9Threads/1DeclarationThread/DeclarationThread.vue";
//9.2
import BlockingAndWaitingThreads
    from "./components/Language/Java/Chapter/9Threads/2ConditionThreads/Theme/BlockingAndWaitingThreads.vue";
import EndedThreads from "./components/Language/Java/Chapter/9Threads/2ConditionThreads/Theme/EndedThreads.vue";
import NewThreads from "./components/Language/Java/Chapter/9Threads/2ConditionThreads/Theme/NewThreads.vue";
import Thread from "./components/Language/Java/Chapter/9Threads/2ConditionThreads/Theme/Thread.vue";
//9.3
import DemonThreads from "./components/Language/Java/Chapter/9Threads/3PropertiesThread/Theme/DemonThreads.vue";
import HandlerUnproccessException
    from "./components/Language/Java/Chapter/9Threads/3PropertiesThread/Theme/HandlerUnproccessException.vue";
import InterruptedThreads
    from "./components/Language/Java/Chapter/9Threads/3PropertiesThread/Theme/InterruptedThreads.vue";
import PriorityThreads from "./components/Language/Java/Chapter/9Threads/3PropertiesThread/Theme/PriorityThreads.vue";
import NamingThreads from "./components/Language/Java/Chapter/9Threads/3PropertiesThread/Theme/NamingThreads.vue";
//9.4
import AtomicOperation from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/AtomicOperation.vue";
import BlockingObject from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/BlockingObject.vue";
import DeadLocks from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/DeadLocks.vue";
import DepricatedMethodsStopAndSuspend
    from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/DepricatedMethodsStopAndSuspend.vue";
import ExampleRaceCondition
    from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/ExampleRaceCondition.vue";
import ExplanationRaceCondition
    from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/ExplanationRaceCondition.vue";
import IfBlocks from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/IfBlocks.vue";
import KeyWorkSynchrinized
    from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/KeyWorkSynchrinized.vue";
import LocalTempsInThread
    from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/LocalTempsInThread.vue";
import MonitorPrincep from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/MonitorPrincep.vue";
import SynchroBlocks from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/SynchroBlocks.vue";
import TypeFinal from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/TypeFinal.vue";
import TypeVolatile from "./components/Language/Java/Chapter/9Threads/4Sinchronization/Theme/TypeVolatile.vue";
//9.5
import AlgorithmsWorkingOnParralelMassive
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/AlgorithmsWorkingOnParralelMassive.vue";
import AtomicUpdateRowInReflections
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/AtomicUpdateRowInReflections.vue";
import BlockingQueue from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/BlockingQueue.vue";
import DepricatedThreadSecurity
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/DepricatedThreadSecurity.vue";
import EffictiveReflectionMapAndQueue
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/EffictiveReflectionMapAndQueue.vue";
import GroupOperationOnParralelHashMap
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/GroupOperationOnParralelHashMap.vue";
import MassiveCopingOnWriting
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/MassiveCopingOnWriting.vue";
import ParralelDeclarationMap
    from "./components/Language/Java/Chapter/9Threads/5ThreadSafeCollection/Theme/ParralelDeclarationMap.vue";
//9.6
import ArchitectureForkLink
    from "./components/Language/Java/Chapter/9Threads/6TaskAndPullsThreads/Theme/ArchitectureForkLink.vue";
import Executions from "./components/Language/Java/Chapter/9Threads/6TaskAndPullsThreads/Theme/Executions.vue";
import InterfacesCallableAndFuture
    from "./components/Language/Java/Chapter/9Threads/6TaskAndPullsThreads/Theme/InterfacesCallableAndFuture.vue";
import ManagerGroupTask
    from "./components/Language/Java/Chapter/9Threads/6TaskAndPullsThreads/Theme/ManagerGroupTask.vue";
//9.7
import EndingFutureActions
    from "./components/Language/Java/Chapter/9Threads/7AsinchronizedCalk/Theme/EndingFutureActions.vue";
import LongTaskInGUI
    from "./components/Language/Java/Chapter/9Threads/7AsinchronizedCalk/Theme/LongTaskInBackcallGUI.vue";
import MakingFutureEndingActions
    from "./components/Language/Java/Chapter/9Threads/7AsinchronizedCalk/Theme/MakingFutureEndingActions.vue";
//9.8
import BuildingProccess from "./components/Language/Java/Chapter/9Threads/8Processes/Theme/BuildingProccess.vue";
import DescriptorsProccess from "./components/Language/Java/Chapter/9Threads/8Processes/Theme/DescriptorsProccess.vue";
import ExecutionProccess from "./components/Language/Java/Chapter/9Threads/8Processes/Theme/ExecutionProccess.vue";
//10.1-10.6
import FromInterationToStreams
    from "./components/Language/Java/Chapter/10Streams/1FromInterationToStreams/FromInterationToStreams.vue";
import CreationStreams from "./components/Language/Java/Chapter/10Streams/2CreationStreams/CreationStreams.vue";
import MethodsFilterMapFlatMap
    from "./components/Language/Java/Chapter/10Streams/3MethodsFilterMapFlatMap/MethodsFilterMapFlatMap.vue";
import ExtractionSubStreamsAndAddingData
    from "./components/Language/Java/Chapter/10Streams/4ExtractionSubStreamsAndAddingData/ExtractionSubStreamsAndAddingData.vue";
import AnotherOperarionOnStreams
    from "./components/Language/Java/Chapter/10Streams/5AnotherOperarionOnStreams/AnotherOperarionOnStreams.vue";
import SimpleMethodsGrouping
    from "./components/Language/Java/Chapter/10Streams/6SimpleMethodsGrouping/SimpleMethodsGrouping.vue";
//10.7
import FactoryUnnessary from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/FactoryUnnessary.vue";
import FormingUnnessasary
    from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/FormingUnnessasary.vue";
import GettingUnnesaryResults
    from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/GettingUnnesaryResults.vue";
import OptinalToStream from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/OptinalToStream.vue";
import UsingUnnesary from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/UsingUnnesary.vue";
import WarningProcessingUnnessasary
    from "./components/Language/Java/Chapter/10Streams/7TypeOptional/Theme/WarningProcessingUnnessasary.vue";
//10.8-10.14
import AccumulationResults
    from "./components/Language/Java/Chapter/10Streams/8AccumulationResults/AccumulationResults.vue";
import AccumulationInReflection
    from "./components/Language/Java/Chapter/10Streams/9AccumulationInReflection/AccumulationInReflection.vue";
import GroupingAndRegrouping
    from "./components/Language/Java/Chapter/10Streams/10GroupingAndRegrouping/GroupingAndRegrouping.vue";
import DowingCollectors from "./components/Language/Java/Chapter/10Streams/11DowingCollectors/DowingCollectors.vue";
import AddingOperation from "./components/Language/Java/Chapter/10Streams/12AddingOperation/AddingOperation.vue";
import SimpleTypeStreams from "./components/Language/Java/Chapter/10Streams/13SimpleTypeStreams/SimpleTypeStreams.vue";
import ParallelStreamsData
    from "./components/Language/Java/Chapter/10Streams/14ParallelStreamsData/ParallelStreamsData.vue";
//11.1
import CodingSymbols from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/CodingSymbols.vue";
import FullComplectInputOutputStreams
    from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/FullComplectInputOutputStreams.vue";
import InputOutputText from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/InputOutputText.vue";
import InputText from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/InputText.vue";
import MixingFiltersStreamsInputOutput
    from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/MixingFiltersStreamsInputOutput.vue";
import OutputText from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/OutputText.vue";
import ReadAndWriteBites
    from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/ReadAndWriteBites.vue";
import SaveObjectInTextFormat
    from "./components/Language/Java/Chapter/11InputOutput/1InputOutput/Theme/SaveObjectInTextFormat.vue";
//11.2
import FilesRandomAccess
    from "./components/Language/Java/Chapter/11InputOutput/2ReadAndWriteBitData/Theme/FilesRandomAccess.vue";
import InterfaceDataInputDataOutput
    from "./components/Language/Java/Chapter/11InputOutput/2ReadAndWriteBitData/Theme/InterfaceDataInputDataOutput.vue";
import ZIPFiles from "./components/Language/Java/Chapter/11InputOutput/2ReadAndWriteBitData/Theme/ZIPFiles.vue";
//11.3
import ChangingSourceMechanizmSerialization
    from "./components/Language/Java/Chapter/11InputOutput/3InputOutputStreamAndSerializable/Theme/ChangingSourceMechanizmSerialization.vue";
import ControlVertions
    from "./components/Language/Java/Chapter/11InputOutput/3InputOutputStreamAndSerializable/Theme/ControlVertions.vue";
import DeclarationFormatFileForSerialization
    from "./components/Language/Java/Chapter/11InputOutput/3InputOutputStreamAndSerializable/Theme/DeclarationFormatFileForSerialization.vue";
import SavingAndLoadingSerializeObject
    from "./components/Language/Java/Chapter/11InputOutput/3InputOutputStreamAndSerializable/Theme/SavingAndLoadingSerializeObject.vue";
import UseSerializationForClonning
    from "./components/Language/Java/Chapter/11InputOutput/3InputOutputStreamAndSerializable/Theme/UseSerializationForClonning.vue";
//11.4
import CopingTempAndDeleteFiles
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/CopingTempAndDeleteFiles.vue";
import CreationFilesAndCatalogies
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/CreationFilesAndCatalogies.vue";
import FilePath from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/FilePath.vue";
import GettingFileInfo
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/GettingFileInfo.vue";
import LookingElementCatalogies
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/LookingElementCatalogies.vue";
import ReadAndWriteInFiles
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/ReadAndWriteInFiles.vue";
import UseCatalogiesStreams
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/UseCatalogiesStreams.vue";
import ZIPSystemFiles
    from "./components/Language/Java/Chapter/11InputOutput/4ManipulatingFiles/Theme/ZIPSystemFiles.vue";
//11.5
import BlockingFiles
    from "./components/Language/Java/Chapter/11InputOutput/5FilesIntoDatamember/Theme/BlockingFiles.vue";
import DataBufferStructure
    from "./components/Language/Java/Chapter/11InputOutput/5FilesIntoDatamember/Theme/DataBufferStructure.vue";
import EffictiveFilesIntoMemory
    from "./components/Language/Java/Chapter/11InputOutput/5FilesIntoDatamember/Theme/EffictiveFilesIntoMemory.vue";
//11.6
import ChangingSame from "./components/Language/Java/Chapter/11InputOutput/6RegularExpression/Theme/ChangingSame.vue";
import FindinManySaneInString
    from "./components/Language/Java/Chapter/11InputOutput/6RegularExpression/Theme/FindinManySaneInString.vue";
import ItemingStringToSeparator
    from "./components/Language/Java/Chapter/11InputOutput/6RegularExpression/Theme/ItemingStringToSeparator.vue";
import SameWithString
    from "./components/Language/Java/Chapter/11InputOutput/6RegularExpression/Theme/SameWithString.vue";
//12.1-3
import IntroductionToXML from "./components/Language/Java/Chapter/12XML/1IntroductionToXML/IntroductionToXML.vue";
import StructureXML from "./components/Language/Java/Chapter/12XML/2StructureXML/StructureXML.vue";
import SyntaxAnalizeXMLDoc from "./components/Language/Java/Chapter/12XML/3SyntaxAnalizeXMLDoc/SyntaxAnalizeXMLDoc.vue";
//12.4
import DeclarationDocType
    from "./components/Language/Java/Chapter/12XML/4CheckingTrustXMLDoc/Theme/DeclarationDocType.vue";
import PracticUseXMLDocUse
    from "./components/Language/Java/Chapter/12XML/4CheckingTrustXMLDoc/Theme/PracticUseXMLDocUse.vue";
import SchemaXML from "./components/Language/Java/Chapter/12XML/4CheckingTrustXMLDoc/Theme/SchemaXML.vue";
//12.5-6
import FindInfoViaXPath from "./components/Language/Java/Chapter/12XML/5FindInfoViaXPath/FindInfoViaXPath.vue";
import UseSpacenaming from "./components/Language/Java/Chapter/12XML/6UseSpacenaming/UseSpacenaming.vue";
//12.7
import SAXAnalizator from "./components/Language/Java/Chapter/12XML/7StreamSyntaxAnalizator/Theme/SAXAnalizator.vue";
import STAXAnalizator from "./components/Language/Java/Chapter/12XML/7StreamSyntaxAnalizator/Theme/STAXAnalizator.vue";
//12.8
import FormingFileViaSVG from "./components/Language/Java/Chapter/12XML/8FormingXMLDoc/Theme/FormingFileViaSVG.vue";
import WriteXMLDoc from "./components/Language/Java/Chapter/12XML/8FormingXMLDoc/Theme/WriteXMLDoc.vue";
import WriteXMLViaSTAX from "./components/Language/Java/Chapter/12XML/8FormingXMLDoc/Theme/WriteXMLViaSTAX.vue";
import XMLWithoutSpacenaming
    from "./components/Language/Java/Chapter/12XML/8FormingXMLDoc/Theme/XMLWithoutSpacenaming.vue";
import XMLWithSpacenaming from "./components/Language/Java/Chapter/12XML/8FormingXMLDoc/Theme/XMLWithSpacenaming.vue";
import TransformationXMLDocViaXSLT
    from "./components/Language/Java/Chapter/12XML/9TransformationXMLDocViaXSLT/TransformationXMLDocViaXSLT.vue";
//13.1
import CallFuncktionAndMethodsFromScenario
    from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/CallFuncktionAndMethodsFromScenario.vue";
import CompileScenario from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/CompileScenario.vue";
import ExeScenario from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/ExeScenario.vue";
import InterpretatorScenario
    from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/InterpretatorScenario.vue";
import RedirectInputOutput
    from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/RedirectInputOutput.vue";
import UseScenarioForProcessingGUI
    from "./components/Language/Java/Chapter/13Annotation/1Scenario/Theme/UseScenarioForProcessingGUI.vue";
//13.2
import CallCompile
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/CallCompile.vue";
import ExampleDiagnosticGeneratedJavaCode
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/ExampleDiagnosticGeneratedJavaCode.vue";
import FicsationDiagnostic
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/FicsationDiagnostic.vue";
import LaunchTaskOnCompile
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/LaunchTaskOnCompile.vue";
import ReadSourceCodeFromOperMemory
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/ReadSourceCodeFromOperMemory.vue";
import WriteBityCodeOnOperMemory
    from "./components/Language/Java/Chapter/13Annotation/2InterfaceAPIForCompiler/Theme/WriteBityCodeOnOperMemory.vue";
//13.3
import ExampleAnnotationProcessorEvent
    from "./components/Language/Java/Chapter/13Annotation/3UseAnnotation/Theme/ExampleAnnotationProcessorEvent.vue";
import IntroInAnnotation
    from "./components/Language/Java/Chapter/13Annotation/3UseAnnotation/Theme/IntroInAnnotation.vue";
//13.4
import AnnotationingAnnouncement
    from "./components/Language/Java/Chapter/13Annotation/4SyntaxAnnotation/Theme/AnnotationingAnnouncement.vue";
import AnnotationingInPlaceUseTypes
    from "./components/Language/Java/Chapter/13Annotation/4SyntaxAnnotation/Theme/AnnotationingInPlaceUseTypes.vue";
import AnnotationingOnLinkThis
    from "./components/Language/Java/Chapter/13Annotation/4SyntaxAnnotation/Theme/AnnotationingOnLinkThis.vue";
import DeclarationAnnotation
    from "./components/Language/Java/Chapter/13Annotation/4SyntaxAnnotation/Theme/DeclarationAnnotation.vue";
import InterfacesAnnotations
    from "./components/Language/Java/Chapter/13Annotation/4SyntaxAnnotation/Theme/InterfacesAnnotations.vue";
//13.5
import AnnotationForCompiling
    from "./components/Language/Java/Chapter/13Annotation/5StandartAnnotation/Theme/AnnotationForCompiling.vue";
import AnnotationForManageResource
    from "./components/Language/Java/Chapter/13Annotation/5StandartAnnotation/Theme/AnnotationForManageResource.vue";
import MetaAnnotation
    from "./components/Language/Java/Chapter/13Annotation/5StandartAnnotation/Theme/MetaAnnotation.vue";
//14.1-9
import DeclarationModules
    from "./components/Language/Java/Chapter/14Modules/1DeclarationModules/DeclarationModules.vue";
import NamingModules from "./components/Language/Java/Chapter/14Modules/2NamingModules/NamingModules.vue";
import ExampleModuleHelloWorld
    from "./components/Language/Java/Chapter/14Modules/3ExampleModuleHelloWorld/ExampleModuleHelloWorld.vue";
import ReqirementModules from "./components/Language/Java/Chapter/14Modules/4ReqirementModules/ReqirementModules.vue";
import ExportModules from "./components/Language/Java/Chapter/14Modules/5ExportModules/ExportModules.vue";
import ModuleArchiveJAR from "./components/Language/Java/Chapter/14Modules/6ModuleArchiveJAR/ModuleArchiveJAR.vue";
import AutoModule from "./components/Language/Java/Chapter/14Modules/7AutoModule/AutoModule.vue";
import UnnamedModules from "./components/Language/Java/Chapter/14Modules/8UnnamedModules/UnnamedModules.vue";
import InstrumentalForWorkingWithModules
    from "./components/Language/Java/Chapter/14Modules/9InstrumentalForWorkingWithModules/InstrumentalForWorkingWithModules.vue";

//Глобальная шина событий
Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false

const routes = [
    {path: '/info', component: InfoMain},
    {path: '/language', component: LanguageMain},
    {path: '/language/java', component: JavaLanguage},
    {path: '/home', component: HomeMain},

    {path: '/page/:id', component: AnotherUserPage},
    {path: '/dialog/:dialogid/user/:userid', component: Dialog},

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
    {path: '/language/java/languageconstruction/symbol/buildingstr', component: BuildingSymbolStr},
    {path: '/language/java/languageconstruction/symbol/checkingsymbolequality', component: CheckingSymbolStrOnEquality},
    {path: '/language/java/languageconstruction/symbol/concatinationstr', component: ConcatinationStr},
    {path: '/language/java/languageconstruction/symbol/constantlysymbolstr', component: ConstantlySymbolStr},
    {path: '/language/java/languageconstruction/symbol/substr', component: SubStr},

    //2.7
    {path: '/language/java/languageconstruction/inputoutput/fileoutputdata', component: FileInputOutputData},
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
    {path: '/language/java/languageconstruction/arrays/copymassive', component: CopyingMassive},
    {path: '/language/java/languageconstruction/arrays/foreach', component: ForEachStyle},
    {path: '/language/java/languageconstruction/arrays/introductionarray', component: IntroductionArray},
    {path: '/language/java/languageconstruction/arrays/multidimentionalmassive', component: MultidimensionalMassive},
    {path: '/language/java/languageconstruction/arrays/sortingmassive', component: SortingMassive},

    //3.1
    {path: '/language/java/oop/intro/classes', component: Classes},
    {path: '/language/java/oop/intro/identificationClasses', component: IdentificationClasses},
    {path: '/language/java/oop/intro/objects', component: Objects},
    {path: '/language/java/oop/intro/relationclasses', component: RelationBetweenClasses},

    //3.2
    {path: '/language/java/oop/tempremake/localdate', component: LocalDate},
    {path: '/language/java/oop/tempremake/objectsandobjectstemp', component: ObjectsAndObjectsTemp},

    //3.3
    {path: '/language/java/oop/defindingownclasses/classyemployee', component: ClassEmployee},
    {path: '/language/java/oop/defindingownclasses/closedMethods', component: ClosedMethods},
    {path: '/language/java/oop/defindingownclasses/constructor', component: Constructor},
    {
        path: '/language/java/oop/defindingownclasses/ExplicitAndUnexplicitParamethers',
        component: ExplicitAndUnexplicitParamethers
    },
    {path: '/language/java/oop/defindingownclasses/incapsulationBenefits', component: IncapsulationBenefits},
    {path: '/language/java/oop/defindingownclasses/EndedField', component: EndedFildCopy},

    //3.4
    {path: '/language/java/oop/staticField/FabricMethods', component: FabricMethods},
    {path: '/language/java/oop/staticField/MethodMain', component: MethodMain},
    {path: '/language/java/oop/staticField/StaticField', component: StaticField},

    //3.5
    {path: '/language/java/oop/paramethrMethods', component: ParamethrMethods},

    //3.6
    {path: '/language/java/oop/constructionObject/BlocksInitialization', component: BlocksInitialization},
    {path: '/language/java/oop/constructionObject/ConstructorWithoutArgs', component: ConstructorWithoutArgs},
    {path: '/language/java/oop/constructionObject/Overload', component: Overload},

    //3.7
    {path: '/language/java/oop/pocket/packets', component: Packets},

    //3.8

    //3.9
    {path: '/language/java/oop/comments/AddingComments', component: AddingComments},
    {path: '/language/java/oop/comments/ClassComment', component: ClassComment},

    //3.10
    {path: '/language/java/oop/RecomendationDevelopmentClasses', component: RecomendationDevelopmentClasses},

    //4.1
    {path: '/language/java/inheritance/AbstractClasses', component: AbstractClasses},
    {path: '/language/java/inheritance/BringingTypes', component: BringingTypes},

    {path: '/language/java/inheritance/DefenitionUnderClasses', component: DefenitionUnderClasses},

    {path: '/language/java/inheritance/HierarchyInheritance', component: HierarchyInheritance},
    {path: '/language/java/inheritance/Polymorfizm', component: Polymorfizm},
    {path: '/language/java/inheritance/PreventionInheritance', component: PreventionInheritance},


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

    //4.4
    {path: '/language/java/inheritance/ObjectShellAndAutoPacking', component: ObjectShellAndAutoPacking},

    //4.5
    {path: '/language/java/inheritance/TempCountParamethersOfMethod', component: TempCountParamethersOfMethod},

    //4.6
    {path: '/language/java/inheritance/EnumClasses', component: EnumClasses},

    //4.7

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

    //9.1
    {path: '/language/java/threads/DeclarationThread', component: DeclarationThread},

    //9.2
    {path: '/language/java/threads/BlockingAndWaitingThreads', component: BlockingAndWaitingThreads},
    {path: '/language/java/threads/EndedThreads', component: EndedThreads},
    {path: '/language/java/threads/NewThreads', component: NewThreads},
    {path: '/language/java/threads/Thread', component: Thread},

    //9.3
    {path: '/language/java/threads/DemonThreads', component: DemonThreads},
    {path: '/language/java/threads/HandlerUnproccessException', component: HandlerUnproccessException},
    {path: '/language/java/threads/InterruptedThreads', component: InterruptedThreads},
    {path: '/language/java/threads/NamingThreads', component: NamingThreads},
    {path: '/language/java/threads/PriorityThreads', component: PriorityThreads},

    //9.4
    {path: '/language/java/threads/AtomicOperation', component: AtomicOperation},
    {path: '/language/java/threads/BlockingObject', component: BlockingObject},
    {path: '/language/java/threads/DeadLocks', component: DeadLocks},
    {path: '/language/java/threads/DepricatedMethodsStopAndSuspend', component: DepricatedMethodsStopAndSuspend},
    {path: '/language/java/threads/ExampleRaceCondition', component: ExampleRaceCondition},
    {path: '/language/java/threads/ExplanationRaceCondition', component: ExplanationRaceCondition},
    {path: '/language/java/threads/IfBlocks', component: IfBlocks},
    {path: '/language/java/threads/KeyWorkSynchrinized', component: KeyWorkSynchrinized},
    {path: '/language/java/threads/LocalTempsInThread', component: LocalTempsInThread},
    {path: '/language/java/threads/MonitorPrincep', component: MonitorPrincep},
    {path: '/language/java/threads/SynchroBlocks', component: SynchroBlocks},
    {path: '/language/java/threads/TypeFinal', component: TypeFinal},
    {path: '/language/java/threads/TypeVolatile', component: TypeVolatile},

    //9.5
    {path: '/language/java/threads/AlgorithmsWorkingOnParralelMassive', component: AlgorithmsWorkingOnParralelMassive},
    {path: '/language/java/threads/AtomicUpdateRowInReflections', component: AtomicUpdateRowInReflections},
    {path: '/language/java/threads/BlockingQueue', component: BlockingQueue},
    {path: '/language/java/threads/DepricatedThreadSecurity', component: DepricatedThreadSecurity},
    {path: '/language/java/threads/EffictiveReflectionMapAndQueue', component: EffictiveReflectionMapAndQueue},
    {path: '/language/java/threads/GroupOperationOnParralelHashMap', component: GroupOperationOnParralelHashMap},
    {path: '/language/java/threads/MassiveCopingOnWriting', component: MassiveCopingOnWriting},
    {path: '/language/java/threads/ParralelDeclarationMap', component: ParralelDeclarationMap},

    //9.6
    {path: '/language/java/threads/ArchitectureForkLink', component: ArchitectureForkLink},
    {path: '/language/java/threads/Executions', component: Executions},
    {path: '/language/java/threads/InterfacesCallableAndFuture', component: InterfacesCallableAndFuture},
    {path: '/language/java/threads/ManagerGroupTask', component: ManagerGroupTask},

    //9.7
    {path: '/language/java/threads/EndingFutureActions', component: EndingFutureActions},
    {path: '/language/java/threads/LongTaskInBackcallGUI', component: LongTaskInGUI},
    {path: '/language/java/threads/MakingFutureEndingActions', component: MakingFutureEndingActions},

    //9.8
    {path: '/language/java/threads/BuildingProccess', component: BuildingProccess},
    {path: '/language/java/threads/DescriptorsProccess', component: DescriptorsProccess},
    {path: '/language/java/threads/ExecutionProccess', component: ExecutionProccess},

    //10.1
    {path: '/language/java/streams/FromInterationToStreams', component: FromInterationToStreams},

    //10.2
    {path: '/language/java/streams/CreationStreams', component: CreationStreams},

    //10.3
    {path: '/language/java/streams/MethodsFilterMapFlatMap', component: MethodsFilterMapFlatMap},

    //10.4
    {path: '/language/java/streams/ExtractionSubStreamsAndAddingData', component: ExtractionSubStreamsAndAddingData},

    //10.5
    {path: '/language/java/streams/AnotherOperarionOnStreams', component: AnotherOperarionOnStreams},

    //10.6
    {path: '/language/java/streams/SimpleMethodsGrouping', component: SimpleMethodsGrouping},

    //10.7
    {path: '/language/java/streams/FactoryUnnessary', component: FactoryUnnessary},
    {path: '/language/java/streams/FormingUnnessasary', component: FormingUnnessasary},
    {path: '/language/java/streams/GettingUnnesaryResults', component: GettingUnnesaryResults},
    {path: '/language/java/streams/OptinalToStream', component: OptinalToStream},
    {path: '/language/java/streams/UsingUnnesary', component: UsingUnnesary},
    {path: '/language/java/streams/WarningProcessingUnnessasary', component: WarningProcessingUnnessasary},

    //10.8
    {path: '/language/java/streams/AccumulationResults', component: AccumulationResults},

    //10.9
    {path: '/language/java/streams/AccumulationInReflection', component: AccumulationInReflection},

    //10.10
    {path: '/language/java/streams/GroupingAndRegrouping', component: GroupingAndRegrouping},

    //10.11
    {path: '/language/java/streams/DowingCollectors', component: DowingCollectors},

    //10.12
    {path: '/language/java/streams/AddingOperation', component: AddingOperation},

    //10.13
    {path: '/language/java/streams/SimpleTypeStreams', component: SimpleTypeStreams},

    //10.14
    {path: '/language/java/streams/ParallelStreamsData', component: ParallelStreamsData},

    //11.1
    {path: '/language/java/inputoutput/CodingSymbols', component: CodingSymbols},
    {path: '/language/java/inputoutput/FullComplectInputOutputStreams', component: FullComplectInputOutputStreams},
    {path: '/language/java/inputoutput/InputOutputText', component: InputOutputText},
    {path: '/language/java/inputoutput/InputText', component: InputText},
    {path: '/language/java/inputoutput/MixingFiltersStreamsInputOutput', component: MixingFiltersStreamsInputOutput},
    {path: '/language/java/inputoutput/OutputText', component: OutputText},
    {path: '/language/java/inputoutput/ReadAndWriteBites', component: ReadAndWriteBites},
    {path: '/language/java/inputoutput/SaveObjectInTextFormat', component: SaveObjectInTextFormat},

    //11.2
    {path: '/language/java/inputoutput/FilesRandomAccess', component: FilesRandomAccess},
    {path: '/language/java/inputoutput/InterfaceDataInputDataOutput', component: InterfaceDataInputDataOutput},
    {path: '/language/java/inputoutput/ZIPFiles', component: ZIPFiles},

    //11.3
    {path: '/language/java/inputoutput/ChangingSourceMechanizmSerialization', component: ChangingSourceMechanizmSerialization},
    {path: '/language/java/inputoutput/ControlVertions', component: ControlVertions},
    {path: '/language/java/inputoutput/DeclarationFormatFileForSerialization', component: DeclarationFormatFileForSerialization},
    {path: '/language/java/inputoutput/SavingAndLoadingSerializeObject', component: SavingAndLoadingSerializeObject},
    {path: '/language/java/inputoutput/UseSerializationForClonning', component: UseSerializationForClonning},

    //11.4
    {path: '/language/java/inputoutput/CopingTempAndDeleteFiles', component: CopingTempAndDeleteFiles},
    {path: '/language/java/inputoutput/CreationFilesAndCatalogies', component: CreationFilesAndCatalogies},
    {path: '/language/java/inputoutput/FilePath', component: FilePath},
    {path: '/language/java/inputoutput/GettingFileInfo', component: GettingFileInfo},
    {path: '/language/java/inputoutput/LookingElementCatalogies', component: LookingElementCatalogies},
    {path: '/language/java/inputoutput/ReadAndWriteInFiles', component: ReadAndWriteInFiles},
    {path: '/language/java/inputoutput/UseCatalogiesStreams', component: UseCatalogiesStreams},
    {path: '/language/java/inputoutput/ZIPSystemFiles', component: ZIPSystemFiles},

    //11.5
    {path: '/language/java/inputoutput/BlockingFiles', component: BlockingFiles},
    {path: '/language/java/inputoutput/DataBufferStructure', component: DataBufferStructure},
    {path: '/language/java/inputoutput/EffictiveFilesIntoMemory', component: EffictiveFilesIntoMemory},

    //11.6
    {path: '/language/java/inputoutput/ChangingSame', component: ChangingSame},
    {path: '/language/java/inputoutput/FindinManySaneInString', component: FindinManySaneInString},
    {path: '/language/java/inputoutput/ItemingStringToSeparator', component: ItemingStringToSeparator},
    {path: '/language/java/inputoutput/SameWithString', component: SameWithString},

    //12.1-3
    {path: '/language/java/xml/IntroductionToXML', component: IntroductionToXML},
    {path: '/language/java/xml/StructureXML', component: StructureXML},
    {path: '/language/java/xml/SyntaxAnalizeXMLDoc', component: SyntaxAnalizeXMLDoc},

    //12.4
    {path: '/language/java/xml/DeclarationDocType', component: DeclarationDocType},
    {path: '/language/java/xml/PracticUseXMLDocUse', component: PracticUseXMLDocUse},
    {path: '/language/java/xml/SchemaXML', component: SchemaXML},

    //12.5-6
    {path: '/language/java/xml/FindInfoViaXPath', component: FindInfoViaXPath},
    {path: '/language/java/xml/UseSpacenaming', component: UseSpacenaming},

    //12.7
    {path: '/language/java/xml/SAXAnalizator', component: SAXAnalizator},
    {path: '/language/java/xml/STAXAnalizator', component: STAXAnalizator},

    //12.8
    {path: '/language/java/xml/FormingFileViaSVG', component: FormingFileViaSVG},
    {path: '/language/java/xml/WriteXMLDoc', component: WriteXMLDoc},
    {path: '/language/java/xml/WriteXMLViaSTAX', component: WriteXMLViaSTAX},
    {path: '/language/java/xml/XMLWithoutSpacenaming', component: XMLWithoutSpacenaming},
    {path: '/language/java/xml/XMLWithSpacenaming', component: XMLWithSpacenaming},

    //12.9
    {path: '/language/java/xml/TransformationXMLDocViaXSLT', component: TransformationXMLDocViaXSLT},

    //13.1
    {path: '/language/java/scenarioandannotation/CallFuncktionAndMethodsFromScenario', component: CallFuncktionAndMethodsFromScenario},
    {path: '/language/java/scenarioandannotation/CompileScenario', component: CompileScenario},
    {path: '/language/java/scenarioandannotation/ExeScenario', component: ExeScenario},
    {path: '/language/java/scenarioandannotation/InterpretatorScenario', component: InterpretatorScenario},
    {path: '/language/java/scenarioandannotation/RedirectInputOutput', component: RedirectInputOutput},
    {path: '/language/java/scenarioandannotation/UseScenarioForProcessingGUI', component: UseScenarioForProcessingGUI},

    //13.2
    {path: '/language/java/scenarioandannotation/CallCompile', component: CallCompile},
    {path: '/language/java/scenarioandannotation/ExampleDiagnosticGeneratedJavaCode', component: ExampleDiagnosticGeneratedJavaCode},
    {path: '/language/java/scenarioandannotation/FicsationDiagnostic', component: FicsationDiagnostic},
    {path: '/language/java/scenarioandannotation/LaunchTaskOnCompile', component: LaunchTaskOnCompile},
    {path: '/language/java/scenarioandannotation/ReadSourceCodeFromOperMemory', component: ReadSourceCodeFromOperMemory},
    {path: '/language/java/scenarioandannotation/WriteBityCodeOnOperMemory', component: WriteBityCodeOnOperMemory},

    //13.3
    {path: '/language/java/scenarioandannotation/ExampleAnnotationProcessorEvent', component: ExampleAnnotationProcessorEvent},
    {path: '/language/java/scenarioandannotation/IntroInAnnotation', component: IntroInAnnotation},

    //13.4
    {path: '/language/java/scenarioandannotation/AnnotationingAnnouncement', component: AnnotationingAnnouncement},
    {path: '/language/java/scenarioandannotation/AnnotationingInPlaceUseTypes', component: AnnotationingInPlaceUseTypes},
    {path: '/language/java/scenarioandannotation/AnnotationingOnLinkThis', component: AnnotationingOnLinkThis},
    {path: '/language/java/scenarioandannotation/DeclarationAnnotation', component: DeclarationAnnotation},
    {path: '/language/java/scenarioandannotation/InterfacesAnnotations', component: InterfacesAnnotations},

    //13.5
    {path: '/language/java/scenarioandannotation/AnnotationForCompiling', component: AnnotationForCompiling},
    {path: '/language/java/scenarioandannotation/AnnotationForManageResource', component: AnnotationForManageResource},
    {path: '/language/java/scenarioandannotation/MetaAnnotation', component: MetaAnnotation},

    //14.1-9
    {path: '/language/java/module/DeclarationModules', component: DeclarationModules},
    {path: '/language/java/module/NamingModules', component: NamingModules},
    {path: '/language/java/module/ExampleModuleHelloWorld', component: ExampleModuleHelloWorld},
    {path: '/language/java/module/ReqirementModules', component: ReqirementModules},
    {path: '/language/java/module/ExportModules', component: ExportModules},
    {path: '/language/java/module/ModuleArchiveJAR', component: ModuleArchiveJAR},
    {path: '/language/java/module/AutoModule', component: AutoModule},
    {path: '/language/java/module/UnnamedModules', component: UnnamedModules},
    {path: '/language/java/module/InstrumentalForWorkingWithModules', component: InstrumentalForWorkingWithModules},

    {path: '/language/kotlin', component: KotlinLanguage},
    {path: '/language/js', component: JSLanguage},

    //test
    {path: '/language/kotlin/1', component: test},

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
