<template>
  <div class="container">
    <!-- <div class="form-content"> -->
    <div style="max-width:600px">
      <el-form :model="form" ref="form" label-width="100px" class="demo-ruleForm">
        <el-form-item label="边长a" prop="edgeA" :rules="rules.edge">
          <el-input type="edgeA" v-model.number="form.edgeA" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="边长b" prop="edgeB" :rules="rules.edge">
          <el-input type="edgeB" v-model.number="form.edgeB" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="边长c" prop="edgeC" :rules="rules.edge">
          <el-input type="edgeC" v-model.number="form.edgeC" autocomplete="off"></el-input>
        </el-form-item>
        <!-- <el-form-item label="选择方法" :rules="rules.method">
          <el-select v-model="form.method" placeholder="等价类">
            <el-option key="equivalence" label="等价类" value="equivalence"></el-option>
            <el-option key="boundary" label="边界值" value="boundary"></el-option>
          </el-select>
        </el-form-item> -->
        <el-form-item style="margin-top:50px">
          <el-button type="primary" @click="submitForm('form')">提交</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { fetchRes } from "../api/triangle";
export default {
  data() {
    return {
      form: {
        edgeA: '',
        edgeB: '',
        edgeC: ''
        // method:"equivalence"
      },
      rules:{
        edge:[
          { required: true, message: '边长不能为空'},
          { type: 'number', message: '边长必须为数字值'}
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
          fetchRes(this.form).then(resp => {
            console.log(resp)
            // this.tableData = resp.data
          })
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