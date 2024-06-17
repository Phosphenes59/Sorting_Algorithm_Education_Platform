<template>
    <div>
        <el-container class="common-layout">
            <el-header class="set-padding">
                <layoutHeader @intro="onIntro" />
            </el-header>
            <el-main v-bind:style="{ minHeight: Height + 'px' }" class="set-padding">
                <slot />
            </el-main>
            <el-footer class="set-padding">
                <layoutFooter />
            </el-footer>
        </el-container>

        <el-dialog class="intro" v-model="introDialogVisible" width="80vw" style="background: transparent;">
            <el-carousel height="80vh" >
                <el-carousel-item v-for="step, key in introSteps" :key="key">
                    <img alt="" :src="step.src">
                </el-carousel-item>
            </el-carousel>
            <slot name="footer">
                <span class="dialog-footer">
                    <el-button @click="introDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="introDialogVisible = false">确 定</el-button>
                </span>
            </slot>
        </el-dialog>
    </div>
</template>

<script>
import layoutHeader from "../header/header.vue";
import layoutFooter from "../footer/footer.vue";

export default {
    name: "mainContainer",
    components: {
        layoutHeader,
        layoutFooter,
    },
    data() {
        return {
            Height: 0,
            introDialogVisible: false,
            introSteps: [
                { src: require('../../assets/intro/learn0-0.png') },
                { src: require('../../assets/intro/learn0-1.png') },
                { src: require('../../assets/intro/learn1-0.png') },
                { src: require('../../assets/intro/learn1-1.png') },
                { src: require('../../assets/intro/learn2-0.png') },
                { src: require('../../assets/intro/learn2-1.png') },
                { src: require('../../assets/intro/learn2-2.png') },
                { src: require('../../assets/intro/learn3-0.png') },
            ]
        }
    },
    methods: {
        onIntro() {
            this.introDialogVisible = true
        }
    },
    mounted() {
        //动态设置内容高度 让footer始终居底   header+footer的高度是100
        this.Height = document.documentElement.clientHeight - 100;
        window.onresize = () => { this.Height = document.documentElement.clientHeight - 100 }
    }
};
</script>
<style scoped>
.set-padding {
    padding: 0px;
}

.common-layout {
    background-size: 100% 100%;
    overflow: hidden;
}

.el-footer {
    --el-footer-height: 40px !important;
}

.intro img {
    width: 100%;
    height: 100%; 
    object-fit: fill;
}
</style>
