<template>
  <section id="load-case" class="pb-8">
    <v-container fluid>
      <v-row align="center" justify="center">
        <v-col cols="10">
          <v-card style="width: 100%;margin:30px 0">
            <!-- <h1 class="text-center pt-6 font-weight-light display-2">Planos</h1> -->
            <v-row align="center" justify="center" style="padding:30px">
              <el-button class="el-icon-download" type="primary" medium plain round
                style="margin:0 150px;width:250px;height:50px;font-size:24px"
                @click = "onSubmit"
              >
              加载用例
              </el-button>
              <el-button class="el-icon-download" type="primary" medium plain round
                style="margin:0 150px;width:250px;height:50px;font-size:24px"
                @click = "onSubmit"
              >
              开始测试
              </el-button>
            </v-row>
            <v-divider class="my-6"></v-divider>
            <div class="text-center">
              <v-col class="col-8 col-sm-8 col-md-8 col-lg-8">
                <el-table
                  :data="tableData"
                  stripe
                >
                  <el-table-column
                    prop="date"
                    label="日期"
                    width="180">
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    label="姓名"
                    width="180">
                  </el-table-column>
                  <el-table-column
                    prop="address"
                    label="地址">
                  </el-table-column>
                </el-table>
              </v-col>
              <v-col class="col-4 col-sm-4 col-md-4 col-lg-4">
                <el-table
                  :data="resData"
                  stripe
                >
                  <el-table-column
                    prop="status"
                    label="结果"
                    width="180">
                  </el-table-column>
                </el-table>
              </v-col>
            </div>
          </v-card>
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
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }],
      resData: [{
        status: 1,
      }, {
        status: 1,
      }, {
        status: 0,
      }, {
      status: 1,
    }]
    }
  },
  created(){
  },
  methods:{
      onSubmit() {
        console.log('submit!')
        this.value = this.$store.state.questionCase
        console.log(this.value)
        console.log(this.value[0])
        console.log(this.value[1])
      }
  }
}
</script>
<style lang="scss">
$main_color: #283e79;

ul {
  font-size: 13px;
  line-height: 1.5em;
  margin: 5px 0 15px;
  padding: 0;

  li {
    list-style: none;
    position: relative;
    padding: 0 0 0 20px;
  }

  li {
    &::before {
      content: "";
      position: absolute;
      left: 0;
      top: 5px;
      width: 10px;
      height: 10px;
      background-color: $main_color;
      border-radius: 50%;
      -moz-border-radius: 50%;
      -webkit-eeborder-radius: 50%;
    }
  }
}
</style>

<style scoped>
.header {
  background-color: #283e79;
  color: white;
}

.circle1 {
  border-radius: 50%;
  width: 150px;
  height: 150px;
  background-color: #f0f8ff;
  display: flex;
  align-items: center;
  justify-content: center;
}

.circle2 {
  border-radius: 50%;
  width: 100px;
  height: 100px;
  background-color: #e0effc;
  display: flex;
  align-items: center;
  justify-content: center;
}

.flex-center {
  display: flex;
  align-items: center;
  justify-content: center;
}

.svg-border-rounded svg {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  color: #f4f7f5;
  z-index: -1;
}

#load-case {
  z-index: 0;
}

.content {
  z-index: 1;
}

svg {
  overflow: hidden;
}

section {
  position: relative;
}
</style>
