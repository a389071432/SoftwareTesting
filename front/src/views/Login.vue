<template>
    <div class="login-wrap">
        <div class="ms-login">
            <el-button  class="ms-button" type="primary" plain  @click="enter()"> 
                进入测试练习题
            </el-button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            
        };
    },
    created() {
        this.$store.commit("clearTags");
    },
    methods: {
        enter(){
            localStorage.setItem("ms_username", "admin");
            this.$router.push("/");
        }
    }
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../assets/img/bg.jpg);
    background-size: 100%;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    min-width: 270px;
    min-height: 200px;
    background: rgba(255, 255, 255, 0.6);
}
.ms-button {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    opacity: 0.8;
}
</style>