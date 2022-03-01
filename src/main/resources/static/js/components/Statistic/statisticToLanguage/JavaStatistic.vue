<template>
  <div class="statistic-main">
    <div class="statistic-header">
      <p>
        Общая статистика
      </p>
    </div>
    <div class="personal-global-stats">
      <p>
        Процент правильности во всех главах
      </p>
      <div id="correctly-percent-all-chapter" v-if="dataOfPercentCorrectAllChapterReady">
        <apexchart type="treemap" height="350" :options="chartTreeOptions" :series="seriesPersentCorrectly"></apexchart>
      </div>
      <p>
        Время затраценнное на главу
      </p>

    </div>
  </div>
</template>

<script>
import ApexCharts from 'apexcharts'
import axios from "axios";

let isSendedandrecivedFor1 = false

let percentCorrectAllChapter = []

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
    }
  },
  mounted() {
    //1 график
    axios.get('http://localhost:9000/java/statistic/', {
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
  }
}
</script>


<style scoped>

</style>