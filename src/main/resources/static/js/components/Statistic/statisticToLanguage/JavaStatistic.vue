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
        <div id="correctly-percent-all-chapter" class="graphic-svg" v-if="dataOfPercentCorrectAllChapterReady">
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
        <div id="count-try-per-theme-number-chapter" class="graphic-svg">
          <div id="realyTryCountPerThemeNumber"></div>
        </div>
      </div>

      <div class="graphic-section">
        <p class="graphic-lable">
          Время затраценнное на главу
        </p>
        <div id="full-time-solution-chapter" class="graphic-svg" v-if="dataOfFullTimeSolutionChapterReady">
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

      <div class="graphic-section">
        <p class="graphic-lable">
          Сравнительный график процентного соотношения правильности вашего решения и
          среднего значения других пользователей
        </p>
        <div id="average-correctly-percent-all-chapter" class="graphic-svg"
             v-if="dataOfAveragePercentCorrectAllChapterReady">
          <apexchart type="area" height="350"
                     :options="averagePercentCorrectlyChartOptions"
                     :series="averagePercentCorrectlySeries"></apexchart>
        </div>
        <div v-if="!dataOfAveragePercentCorrectAllChapterReady">
          <p class="graphic-lable">
            Данные отсутствуют, возможно вы еще не прошли ни одной главы
          </p>
        </div>
      </div>

      <div class="graphic-section">
        <p class="graphic-lable">
          Сравнительный график затраченного времени в секундах на решение главы пользователемями и вами
        </p>
        <div id="average-time-on-chapter-spend" class="graphic-svg" v-if="dataOfAverageTimeSpendOnSolutionReady">
          <apexchart type="area" height="350"
                     :options="averagePercentCorrectlyChartOptions"
                     :series="averageTimeSpendOnSolutionSeries"></apexchart>
        </div>
        <div v-if="!dataOfAverageTimeSpendOnSolutionReady">
          <p class="graphic-lable">
            Данные отсутствуют, возможно вы еще не прошли ни одной главы
          </p>
        </div>
      </div>

      <div class="graphic-section">
        <p class="graphic-lable">
          Радиальный график демонстрации процентной завершенности глав
        </p>
        <div id="percent-of-ending-in-chapters" class="graphic-svg" v-if="dataOfPercentEndedThemesInChapterReady">
          <apexchart type="radialBar" height="600"
                     :options="chartPercentEndedThemesInChapterOptions"
                     :series="percentEndedThemesInChapterSeries"></apexchart>
        </div>
        <div v-if="!dataOfPercentEndedThemesInChapterReady">
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
let isSendedandrecivedFor4 = false
let isSendedandrecivedFor5 = false
let isSendedandrecivedFor6 = false

//1
let percentCorrectAllChapter = []
//2
let realTryCountPerThemeNumber = []
//3
let dataOfFullTimeSolutionChapter = []
//4
let dataOfAveragePercentCorrectlyAnotherUsers = []
//5
let dataOfAverageTimeSpendOnSolutionChapter = []
//6
let dataOfPercentEndedThemesInChapter = []
let absoluteFinishedJavaLanguage = 0.0

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

      //4
      dataOfAveragePercentCorrectAllChapter: [],
      dataOfAveragePercentCorrectAllChapterReady: false,

      averagePercentCorrectlySeries: [],
      averagePercentCorrectlyChartOptions: {
        chart: {
          height: 350,
          type: 'area'
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          curve: 'smooth'
        },
        markers: {
          colors: ['#F44336', '#E91E63', '#9C27B0']
        },
        xaxis: {
          categories: ["Глава 1", "Глава 2", "Глава 3", "Глава 4",
            "Глава 5", "Глава 6", "Глава 7", "Глава 8",
            "Глава 9", "Глава 10", "Глава 11", "Глава 12"]
        }
      },

      //5
      dataOfAverageTimeSpendOnSolution: [],
      dataOfAverageTimeSpendOnSolutionReady: false,

      averageTimeSpendOnSolutionSeries: [],

      //6
      dataOfPercentEndedThemesInChapter: [],
      dataOfPercentEndedThemesInChapterReady: false,

      percentEndedThemesInChapterSeries: [],
      chartPercentEndedThemesInChapterOptions: {
        chart: {
          height: 350,
          type: 'radialBar',
        },
        plotOptions: {
          radialBar: {
            dataLabels: {
              name: {
                fontSize: '22px',
              },
              value: {
                fontSize: '16px',
              },
              total: {
                show: true,
                label: 'Пройдено',
                formatter: function (w) {
                  // By default this function returns the average of all series. The below is just an example to show the use of custom formatter function
                  return absoluteFinishedJavaLanguage + '% '
                }
              }
            }
          }
        },
        labels: ["Глава 1", "Глава 2", "Глава 3", "Глава 4",
          "Глава 5", "Глава 6", "Глава 7", "Глава 8",
          "Глава 9", "Глава 10", "Глава 11", "Глава 12"],
      },

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
    },

    extractPersonalCorrectlyPersent() {
      let massiveData = []

      if (this.dataOfPercentCorrectAllChapterReady)
        for (let i = 0; i < this.dataOfPercentCorrectAllChapter.length; i++) {
          massiveData[i] = this.dataOfPercentCorrectAllChapter[i].percentCorrectly
        }

      return massiveData
    },

    extractPersonalTimeOnSolution() {
      let massiveData = []

      if (this.dataOfFullTimeSolutionChapterReady)
        for (let i = 0; i < this.dataOfFullTimeSolutionChapter.length; i++) {
          massiveData[i] = this.dataOfFullTimeSolutionChapter[i].chapterTimeSpend
        }

      return massiveData
    },

    extractPercentFinishedChapter() {
      let massiveData = []

      for (let i = 0; i < this.dataOfPercentEndedThemesInChapter.length - 1; i++) {
        massiveData[i] = this.dataOfPercentEndedThemesInChapter[i]
      }

      absoluteFinishedJavaLanguage = this.dataOfPercentEndedThemesInChapter[this.dataOfPercentEndedThemesInChapter.length - 1]

      return massiveData
    }
  },
  mounted() {
    //1
    axios.get('/java/statistic/percentCorrectly', {
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
    axios.get('/java/statistic/tryCountPerThemeNumber', {
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
    axios.get('/java/statistic/timeOnChapter', {
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

    //4
    axios.get('/java/statistic/avaragePercentCorrectly', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          dataOfAveragePercentCorrectlyAnotherUsers = response.data

          isSendedandrecivedFor4 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval4Graph = setInterval(() => {
      if (isSendedandrecivedFor4 && this.dataOfPercentCorrectAllChapterReady) {
        isSendedandrecivedFor4 = false

        this.dataOfAveragePercentCorrectAllChapter = dataOfAveragePercentCorrectlyAnotherUsers

        this.averagePercentCorrectlySeries = [{
          name: 'Ваши результаты',
          data: this.extractPersonalCorrectlyPersent()
        }, {
          name: 'Средние результаты',
          data: this.dataOfAveragePercentCorrectAllChapter
        }]

        this.dataOfAveragePercentCorrectAllChapterReady = true
        clearInterval(interval4Graph)
      }
    }, 200)

    //5
    axios.get('/java/statistic/avarageTimeOnSolution', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          dataOfAverageTimeSpendOnSolutionChapter = response.data

          isSendedandrecivedFor5 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval5Graph = setInterval(() => {
      if (isSendedandrecivedFor5 && this.dataOfFullTimeSolutionChapterReady) {
        isSendedandrecivedFor5 = false

        this.dataOfAverageTimeSpendOnSolution = dataOfAverageTimeSpendOnSolutionChapter

        this.averageTimeSpendOnSolutionSeries = [{
          name: 'Ваши результаты',
          data: this.extractPersonalTimeOnSolution()
        }, {
          name: 'Средние результаты',
          data: this.dataOfAverageTimeSpendOnSolution
        }]

        this.dataOfAverageTimeSpendOnSolutionReady = true
        clearInterval(interval5Graph)
      }
    }, 200)

    //6
    axios.get('/java/statistic/percentOfEndinOfChapter', {
      params: {
        userId: window.frontendData.profile.id
      }
    })
        .then(function (response) {
          dataOfPercentEndedThemesInChapter = response.data

          isSendedandrecivedFor6 = true
        })
        .catch(function (error) {
          console.log(error);
        })
    const interval6Graph = setInterval(() => {
      if (isSendedandrecivedFor6) {
        isSendedandrecivedFor6 = false

        this.dataOfPercentEndedThemesInChapter = dataOfPercentEndedThemesInChapter

        this.percentEndedThemesInChapterSeries = this.extractPercentFinishedChapter()

        this.dataOfPercentEndedThemesInChapterReady = true
        clearInterval(interval6Graph)
      }
    }, 200)
  }
}
</script>

<style scoped>

</style>