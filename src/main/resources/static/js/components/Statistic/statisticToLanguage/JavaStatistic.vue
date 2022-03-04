<template>
  <div class="statistic-main">
    <div class="statistic-header">
      <p class="statistic-main-lable">
        Общая статистика
      </p>
    </div>
    <div class="personal-global-stats">
      <div class="graphic-section">
        <p class="graphic-lable">
          Процент правильности во всех главах
        </p>
        <div id="correctly-percent-all-chapter" v-if="dataOfPercentCorrectAllChapterReady">
          <apexchart type="treemap" height="350"
                     :options="chartTreeOptions"
                     :series="seriesPersentCorrectly"></apexchart>
        </div>
        <div v-if="!dataOfPercentCorrectAllChapterReady">
          <p class="graphic-lable">
            Данные отсутствуют, возможно вы еще не прошли ни одной главы
          </p>
        </div>
      </div>

      <div class="graphic-section">
        <p class="graphic-lable">
          Количество попыток решения и количество тем в главе
        </p>
        <div id="count-try-per-theme-number-chapter">
          <div id="realyTryCountPerThemeNumber"></div>
        </div>
      </div>

      <div class="graphic-section">
        <p class="graphic-lable">
          Время затраценнное на главу
        </p>
        <div id="full-time-solution-chapter" v-if="dataOfFullTimeSolutionChapterReady">
          <apexchart type="treemap" height="350"
                     :options="chartTreeOptions"
                     :series="seriesChapterFullTimeSolution"></apexchart>
        </div>
        <div v-if="!dataOfFullTimeSolutionChapterReady">
          <p class="graphic-lable">
            Данные отсутствуют, возможно вы еще не прошли ни одной главы
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ApexCharts from 'apexcharts'
import axios from "axios";

let isSendedandrecivedFor1 = false
let isSendedandrecivedFor2 = false
let isSendedandrecivedFor3 = false

//1
let percentCorrectAllChapter = []
//2
let realTryCountPerThemeNumber = []
//3
let dataOfFullTimeSolutionChapter = []

export default {
  name: "JavaStatistic",
  data: function () {
    return {
      //1
      dataOfPercentCorrectAllChapter: [],
      dataOfPercentCorrectAllChapterReady: false,

      seriesPersentCorrectly: [
        {
          data: []
        }
      ],

      //2
      dataOfRealTryCountPerThemeNumber: [],
      dataOfRealTryCountPerThemeNumberReady: false,

      //3
      dataOfFullTimeSolutionChapter: [],
      dataOfFullTimeSolutionChapterReady: false,

      seriesChapterFullTimeSolution: [
        {
          data: []
        }
      ],

      //1 and 3
      chartTreeOptions: {
        legend: {
          show: false
        },
        chart: {
          height: 350,
          type: 'treemap'
        },
        title: {
          text: 'Basic Treemap'
        }
      },
    }
  },
  methods: {
    prepareDataElementToPercentCorrectlyOfAllChapters() {
      let massiveData = []

      for (let i = 0; i < this.dataOfPercentCorrectAllChapter.length; i++) {
        massiveData[i] = {
          x: this.dataOfPercentCorrectAllChapter[i].chapterNumber + ' Глава',
          y: this.dataOfPercentCorrectAllChapter[i].percentCorrectly
        }
      }

      return massiveData
    },

    prepareDataRealTryCountPerThemeNumberChapter() {
      let massiveData = []

      for (let i = 0; i < this.dataOfRealTryCountPerThemeNumber.length; i++) {
        massiveData[i] = {
          x: this.dataOfRealTryCountPerThemeNumber[i].chapterNumber + ' Глава ',
          y: this.dataOfRealTryCountPerThemeNumber[i].chapterRealTryCount,
          goals: [
            {
              name: 'Expected',
              value: this.dataOfRealTryCountPerThemeNumber[i].chapterRealThemeCount,
              strokeHeight: 5,
              strokeColor: '#775DD0'
            }
          ]
        }
      }

      return massiveData
    },

    getObjectToRealTryCountPerThemeNumber() {
      return {
        series: [
          {
            name: 'Actual',
            data: this.prepareDataRealTryCountPerThemeNumberChapter()
          }
        ],
        chart: {
          height: 350,
          type: 'bar'
        },
        plotOptions: {
          bar: {
            columnWidth: '60%'
          }
        },
        colors: ['#00E396'],
        dataLabels: {
          enabled: false
        },
        legend: {
          show: true,
          showForSingleSeries: true,
          customLegendItems: ['Actual', 'Expected'],
          markers: {
            fillColors: ['#00E396', '#775DD0']
          }
        }
      };
    },

    prepareDataElementToFullTimeSolutionChapter() {
      let massiveData = []

      for (let i = 0; i < this.dataOfFullTimeSolutionChapter.length; i++) {
        massiveData[i] = {
          x: this.dataOfFullTimeSolutionChapter[i].chapterNumber + ' Глава ',
          y: this.dataOfFullTimeSolutionChapter[i].chapterTimeSpend
        }
      }

      return massiveData
    }
  },
  mounted() {
    //1
    axios.get('http://localhost:9000/java/statistic/percentCorrectly', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          percentCorrectAllChapter = response.data

          isSendedandrecivedFor1 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval1Graph = setInterval(() => {
      if (isSendedandrecivedFor1) {
        isSendedandrecivedFor1 = false

        this.dataOfPercentCorrectAllChapter = percentCorrectAllChapter

        let preparedData = this.prepareDataElementToPercentCorrectlyOfAllChapters()

        this.seriesPersentCorrectly[0] = {
          data:
          preparedData
        }

        this.dataOfPercentCorrectAllChapterReady = true
        clearInterval(interval1Graph)
      }
    }, 200)

    //2
    axios.get('http://localhost:9000/java/statistic/tryCountPerThemeNumber', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          realTryCountPerThemeNumber = response.data

          isSendedandrecivedFor2 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval2Graph = setInterval(() => {
      if (isSendedandrecivedFor2) {
        isSendedandrecivedFor2 = false

        this.dataOfRealTryCountPerThemeNumber = realTryCountPerThemeNumber

        let realyTryCountPerThemeNumberChart = new ApexCharts(document.querySelector(
                "#realyTryCountPerThemeNumber")
            , this.getObjectToRealTryCountPerThemeNumber()
        );
        realyTryCountPerThemeNumberChart.render();

        clearInterval(interval2Graph)
      }
    }, 200)

    //3
    axios.get('http://localhost:9000/java/statistic/timeOnChapter', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          dataOfFullTimeSolutionChapter = response.data

          isSendedandrecivedFor3 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval3Graph = setInterval(() => {
      if (isSendedandrecivedFor3) {
        isSendedandrecivedFor3 = false

        this.dataOfFullTimeSolutionChapter = dataOfFullTimeSolutionChapter

        let preparedData = this.prepareDataElementToFullTimeSolutionChapter()

        this.seriesChapterFullTimeSolution[0] = {
          data: preparedData
        }

        this.dataOfFullTimeSolutionChapterReady = true
        clearInterval(interval3Graph)
      }
    }, 200)
  }
}
</script>


<style scoped>

</style>