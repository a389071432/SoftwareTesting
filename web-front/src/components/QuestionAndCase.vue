<template>
  <section id="question">
    <v-container fluid>
      <v-row align="center" justify="center">
        <v-col cols="10">
          <v-row align="center" justify="center">
            <v-col cols="12" md="7">
              <h1 class="font-weight-light display-2">Test Kits</h1>
              <h1 class="font-weight-light display-1 mb-3">
                选择题目
              </h1>
              <v-row>
                <v-col cols="12" class="d-flex align-center">
                  <div class="block">
                    <!-- <span class="demonstration">hover 触发子菜单</span> -->
                    <el-cascader
                      v-model="value"
                      :options="options"
                      size = 'medium'
                      :props="{ expandTrigger: 'hover' }"
                      @change="handleChange">
                    </el-cascader>
                  </div>
                </v-col>
                <v-col cols="12" class="d-flex align-center" v-if="value[0] === 'triangle'">
                  <v-img
                    src="@/assets/img/pro-triangle.svg"
                    max-width="60px"
                    class="mr-4"
                  />
                  <p class="text-justify">
本题需要根据输入的三个正数变量a、b、c，判断以这三个整数为边的三角形类型。<br><br>
在这里我们对程序的输出格式加以规定，以方便之后的测试，对于不同类型的三角形，程序分别输出“等边三角形”、“等腰三角形”和“一般三角形”。<br><br>
同时针对可能存在的a、b、c三条边无法构成三角形的异常情况，输出“无法构成三角形”。
                  </p>
                </v-col>
                <v-col cols="12" class="d-flex align-center" v-if="value[0] === 'calendar'">
                  <v-img
                    src="@/assets/img/pro-calendar.svg"
                    max-width="60px"
                    class="mr-4"
                  />
                  <p class="text-justify">
本题需要根据输入的年月日三个正整数变量，得到下一天的日期输出。<br><br>
在这里，我们规定程序输出格式为形如“yyyy-mm-dd”形式的的字符串，同时，对于非法的输入，程序应输出“非法输入”。
                  </p>
                </v-col>
                <v-col cols="12" class="d-flex align-center" v-if="value[0] === 'computer'">
                  <v-img
                    src="@/assets/img/pro-computer.svg"
                    max-width="60px"
                    class="mr-4"
                  />
                  <p class="text-justify">
本题考虑的是一个电脑销售系统，统计销售员的销售总额及销售佣金，为了确保销售额的计算以及对应销售佣金按照相应等级的激素啊安是正确的，需要对该系统进行测试。<br><br>
该系统的输入有三种：主机、显示器、和外设的销售数量：<br><br>
主机（25￥单位价格，每月最多销售的数量为70），显示器（30￥单位价格，每月最多销售数量为80），外设（45￥单位价格，每月最多销售的数量为90）；每个销售员每月至少销售一台完整的机器，当系统的主机这个变量接受到-1值的时候，系统自动统计该销售员本月的销售总额。<br><br>
当销售额小于等于1000（包括1000）按照10%提佣金，当销售额在1000-1800之间（包括1800）的时候按照15%提佣金，当销售额大于1800时按照20%提佣金。<br><br>
根据各产品的单价乘以各产品销售数量，并进行累加即可计算出销售总额和相应的销售佣金。
                  </p>
                </v-col>
                <v-col cols="12" class="d-flex align-center" v-if="value[0] === 'phone'">
                  <v-img
                    src="@/assets/img/pro-phone.svg"
                    max-width="60px"
                    class="mr-4"
                  />
                  <p class="text-justify">
本题考虑一个电信收费问题系统，需求描述如下：<br><br>
每月的电话总费用=基本月租费+折扣后的实际的通话费，如果没有折扣则按实际通话费计算，基本月租费为25元，每分钟通话费为0.15元。<br><br>
实际通话费是否有折扣与当月的通话时间（分钟）和本年度至本月的累计未按时缴费的次数有关。跨年度未交费与折扣无关，但跨年未交部分每月需要交付总额5%的滞纳金。<br><br>
当月的通话分钟数和折扣比例及本年度未按时缴费次数之间有直接的对应关系，如果本年度的未按时缴费的次数超过本月通话时间所对应的容许值则免于折扣，并按实际的通话费计算。<br><br>
电话费采用在线支付，支付方式为：支付宝或银行卡（开发简单的模拟子系统），支付后打印支付成功或不成功清单。
                  </p>
                </v-col>
              </v-row>
            </v-col>
            <v-col cols="12" md="5" class="d-none d-md-flex">
              <v-img
                src="@/assets/img/ill1.svg"
                class="d-block ml-auto mr-auto"
                max-width="400px"
              />
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
        value: [],
        options: [
          {
            value: 'triangle',
            label: '三角形',
            children:[
              {
                value: 'boundary',
                label: '边界值'
              }, 
              {
                value: 'equivalent',
                label: '等价类'
              }
            ]
          },
          {
            value: 'calendar',
            label: '万年历',
            children:[
              {
                value: 'boundary',
                label: '边界值'
              }, 
              {
                value: 'equivalent',
                label: '等价类'
              }
            ]
          },
          {
            value: 'computer',
            label: '电脑销售',
            children:[
              {
                value: 'boundary',
                label: '边界值'
              }, 
              {
                value: 'equivalent',
                label: '等价类'
              }
            ]
          },
          {
            value: 'phone',
            label: '电信收费',
            children:[
              {
                value: 'boundary',
                label: '边界值'
              }, 
              {
                value: 'equivalent',
                label: '等价类'
              }
            ]
          },
        ], 
      };
    },
    methods: {
      handleChange(value) {
        console.log(value);
        this.$store.dispatch({
            type: 'setQuestionAndCase',
            value: this.value
        });
      }
    }
  };
</script>

<style scoped>
#question {
  background-color: #f4f7f5;
}
/deep/ .el-cascader {
  width: 500px;
  
  >>>.el-input{
    font-size:40px;
    height: 80px;
  }
}
</style>
