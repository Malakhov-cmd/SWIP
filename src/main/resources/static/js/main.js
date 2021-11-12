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
import AccessToElement from "./components/Language/Java/Chapter/2LanguageConstruction/10Arrays/Theme/AccessToElement.vue";
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

//Глобальная шина событий
Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false

const routes = [
    {path: '/home', component: HomeMain},
    {path: '/language' , component: LanguageMain},
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
    {path: '/language/java/languageconstruction/operations/combinationarithmetoper', component: CombinationArithmethicOperationWithAssignment},
    {path: '/language/java/languageconstruction/operations/incrementdecrement', component:IncrementAndDecrement},
    {path: '/language/java/languageconstruction/operations/mathfunction', component: MathFunctionAndConstants},
    {path: '/language/java/languageconstruction/operations/relationshionshipoperation', component: RelashionshipOperationAndBoolean},
    {path: '/language/java/languageconstruction/operations/hierarchyoperation', component: RoundBraceAndHierarchyOperattion},
    {path: '/language/java/languageconstruction/operations/transformationdigittype', component: TransformationDigitType},

    //2.6
    {path: '/language/java/languageconstruction/symbol/apistr', component: API_Str},
    {path: '/language/java/languageconstruction/symbol/buildingstr', component: BuildingSymbolStr},
    {path: '/language/java/languageconstruction/symbol/checkingsymbolequality', component: CheckingSymbolStrOnEquality},
    {path: '/language/java/languageconstruction/symbol/codepoint', component: CodePointAndUnits},
    {path: '/language/java/languageconstruction/symbol/concatinationstr', component: ConcatinationStr},
    {path: '/language/java/languageconstruction/symbol/constantlysymbolstr', component: ConstantlySymbolStr},
    {path: '/language/java/languageconstruction/symbol/emptyzerostr', component: EmptyZeroStr},
    {path: '/language/java/languageconstruction/symbol/substr', component:SubStr},

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
