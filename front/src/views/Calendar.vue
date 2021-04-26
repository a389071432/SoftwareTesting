<template>
  <div class="container">
    <!-- <div class="form-content"> -->
    <div style="max-width:600px">
      <el-form :model="form" ref="form" label-width="100px" class="demo-ruleForm">
        <el-form-item label="年" prop="year" :rules="rules.number">
          <el-input type="year" v-model.number="form.year" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="月" prop="months" :rules="rules.number">
          <el-input type="months" v-model.number="form.months" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="日" prop="day" :rules="rules.number">
          <el-input type="day" v-model.number="form.day" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="选择方法" :rules="rules.method">
          <el-select v-model="form.method" placeholder="等价类">
            <el-option key="equivalence" label="等价类" value="equivalence"></el-option>
            <el-option key="boundary" label="边界值" value="boundary"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item style="margin-top:50px">
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          year: '',
          months: '',
          day: '',
          method:"equivalence"
        },
        rules:{
          number:[
            { required: true, message: '该处不能为空'},
            { type: 'number', message: '该处必须为数字值'}
          ],
          method:[
            { required: true, message: '请选择测试方法'}
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.form)
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
.container{
  min-height: 800px;
}
.form-content {
  position: absolute;
  width: 600px;
  left:50%;
  transform: translateX(-50%);
}
</style>