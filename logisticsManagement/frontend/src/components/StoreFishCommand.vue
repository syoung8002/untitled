<template>
    <v-card outlined>
        <v-card-title>
            StoreFish
        </v-card-title>

        <v-card-text>
            <String label="LogisticsId" v-model="value.logisticsId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="storeFish"
            >
                StoreFish
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'StoreFishCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.logisticsId = '';
        },
        watch: {
        },
        methods: {
            storeFish() {
                this.$emit('storeFish', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

