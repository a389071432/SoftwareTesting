<template>
  <section id="download">
    <v-container fluid>
      <v-row align="center" justify="center">
        <v-col cols="10">
          <v-row align="center" justify="center">
            <v-col sm="4" class="hidden-xs-only">
              <v-img src="@/assets/img/ill2.svg" class="d-block ml-auto mr-auto" max-width="350px" />
            </v-col>
            <v-col cols="12" sm="8" class="white--text text-left">
              <h1 class="font-weight-light display-2 mb-2">Baixar Demonstração</h1>
              <h1 class="font-weight-light">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Iste ex
                animi quod laboriosam vel blanditiis labore alias, aliquid,
                tempora repellendus non.
              </h1>
              <!-- <v-row align="center" justify="center" >
                <v-col cols="4" sm="4"style="margin-top:40px">
                  <el-cascader
                    v-model="value"
                    :options="options"
                    size = 'medium'
                    :props="{ expandTrigger: 'hover' }"
                    @change="handleChange">
                  </el-cascader>
                </v-col>
                <v-col cols="4" sm="4" style="margin-top:30px">
                  <v-img
                    v-if="value[0] === 'triangle'"
                    src="@/assets/img/pro-triangle.svg"
                    width="100px"
                    class="mr-4"
                  />
                  <v-img
                    v-if="value[0] === 'calendar'"
                    src="@/assets/img/pro-calendar.svg"
                    max-width="100px"
                    class="mr-4"
                  />
                  <v-img
                    v-if="value[0] === 'computer'"
                    src="@/assets/img/pro-computer.svg"
                    max-width="100px"
                    class="mr-4"
                  />
                  <v-img
                    v-if="value[0] === 'phone'"
                    src="@/assets/img/pro-phone.svg"
                    max-width="100px"
                    class="mr-4"
                  />
                </v-col>
              </v-row> -->
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script>
export default {
  data() {
    return {
      value:[],
      options: [{
        value: 'triangle',
        label: '三角形'
      },{
        value: 'calendar',
        label: '万年历'
      },{
        value: 'computer',
        label: '电脑销售'
      },{
        value: 'phone',
        label: '电信收费'
      }]
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
      this.$store.dispatch({
        type: 'setQuestion',
        value: this.value
      });
    }
  }
}
</script>

<style scoped>
#download {
  background-image: url("~@/assets/img/bgDownload.jpg");
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  height: 500px;
}

#download .container,
#download .row {
  height: 100%;
}
</style>