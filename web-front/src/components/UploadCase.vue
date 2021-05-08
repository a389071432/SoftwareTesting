<template>
  <section id="upload-case" class="pb-8">
    <v-container fluid>
      <v-row align="center" justify="center">
        <v-col cols="10">
          <v-card style="width: 100%;margin:30px 0">
            <v-row align="center" justify="center" >
                <v-col cols="3" sm="3"style="margin-top:40px"/>
                <v-col cols="4" sm="4"style="margin-top:40px">
                  <div>选择题目: </div>
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
              </v-row>
            <v-row align="center" justify="center" style="padding:30px">
              <upload-excel-component :on-success="handleSuccess" :before-upload="beforeUpload" />
            </v-row>
            <v-row v-if="tableData.length!=0" align="center" justify="center" style="padding:30px">
              <el-button class="el-icon-download" type="primary" medium plain round
                style="margin:0 150px;width:250px;height:50px;font-size:24px"
                @click="onTest"
              >
              开始测试
              </el-button>
            </v-row>
            <v-divider class="my-6"></v-divider>
            <div class="text-center">
              <el-table stripe :data="tableData" highlight-current-row style="width: 100%;margin-top:20px;"
                :row-class-name="tableRowClassName" @row-click = "onRowClick" @selection-change="handleSelectionChange"
              >
                <el-table-column v-if="tableData.length!=0" type="selection" width="55"/>
                <el-table-column v-for="item of tableHeader" :key="item" :prop="item" :label="item"/>
              </el-table>
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script>
import UploadExcelComponent from '@/components/UploadExcel/index.vue'
import {fetchResult} from '@/api/index'

export default {
  name: 'UploadExcel',
  components: { UploadExcelComponent },
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
      }],
      tableData: [],
      tableHeader: [],
      selection: []
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
      this.$store.dispatch({
        type: 'setQuestion',
        value: this.value
      });
    },
    handleSelectionChange(val) {
      this.selection = val;
    },
    onTest(){
      if(this.$store.state.question.length==0){
        this.$message({
          message: "请选择题目！",
          type: 'error'
        })
      }
      else if(this.selection.length==0){
        this.$message({
          message: "请勾选用例项！",
          type: 'error'
        })
      }
      else{
        console.log(this.selection);
        this.selection.forEach(item => {
          let query={
            question:this.$store.state.question,
            case:JSON.stringify(item)
          }
          console.log(query)
          fetchResult(query).then(resp=>{
            console.log("=======success！！！=====")
            console.log(resp)
          // this.tableData[item.index].Result = "correct"
          // this.$set(this.tableData, item.index,item)
          })
        })
      }
    },
    tableRowClassName ({row,rowIndex}) {
      //把每-行的索弓|放进row
      row.index=rowIndex
    },
    onRowClick (row, event, column) {
      //行点击消除new标记
      // console.log(row)
      // var index = row.index
      // console.log(index)
      // this.tableData[index].Result = "correct"
      // this.$set(this.tableData, index, row)
    },
    beforeUpload(file) {
      const isLt1M = file.size / 1024 / 1024 < 1
      if (isLt1M) {
        return true
      }
      this.$message({
        message: 'Please do not upload files larger than 1m in size.',
        type: 'warning'
      })
      return false
    },
    handleSuccess({ results, header }) {
      this.tableData = results
      this.tableHeader = header
    }
    // onTest(){
    //   if(this.$store.state.question.length==0){
    //     this.$message({
    //       message: "请选择题目！",
    //       type: 'error'
    //     })
    //   }
    //   else{
    //     let query={
    //       question:this.$store.state.question,
    //       tableData:JSON.stringify(this.tableData)
    //       // tableData:this.tableData
    //       // tableData:'[{\"a\":0,\"b\":50,\"c\":50,\"ExpectedOutput\":\"name\",\"index\":0}]'
    //       // tableData:"table"
    //     }
    //     console.log(typeof query.question);
    //     console.log(typeof query.tableData[0]);
    //     console.log(query)
    //     console.log(Date())
    //     fetchResult(query).then(resp=>{
    //       console.log("=======success！！！=====")
    //       console.log(resp)
    //     })
    //   }
    // },
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

#upload-case {
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
