<template>
    <v-container fluid>
        <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
            <v-img style="width:100%; height:300px;"
                src=""
            ></v-img>
            <div class="App-main-text-overlap">
                
            </div>
            <div class="App-sub-text-overlap">
                
            </div>
        </div>
        <v-row>
            <v-col v-for="(aggregate, index) in aggregate" 
                    :key="index"
                    cols="4"
                    class="d-flex justify-center" 
            >
                <div 
                    class="flip-card"
                    @mouseover="flipCard(index)"
                    @mouseleave="unflipCard(index)"
                    :class="{ 'is-flipped': flipped[index] }"
                >
                    <div class="flip-card-inner">
                        <div class="flip-card-front">
                            <v-card
                                class="mx-auto"
                                style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                outlined
                            >
                                <v-list-item style="padding:15px; margin:0px;">
                                    <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                </v-list-item>
                                <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                    <h2>{{ aggregate.title }}</h2>
                                    <div>{{ aggregate.description }}</div>
                                </div>
                            </v-card>
                        </div>
                        <div class="flip-card-back">
                            <v-card
                                color="primary"
                                class="mx-auto"
                                style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                outlined
                                :key="aggregate.key"
                                :to="aggregate.route"
                            >
                                <v-list-item style="padding:15px; margin:0px;">
                                    <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                </v-list-item>
                                <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                            </v-card>
                        </div>
                    </div>
                </div>
            </v-col>
        </v-row>
    </v-container>  
</template>

<script>
export default {
    name: "Home",
    data: () => ({
        flipped: [],    
        aggregate: [
            { 
                title: '주문', 
                description: '고객이 주문한 생선 제품 주문 정보를 담당하는 Aggregate', 
                key: 'orders', 
                route: '/orderManagements/orders',
                ImageUrl: '',
            },
            { 
                title: '생산', 
                description: '생선 생산 계획 및 생산 요청을 담당하는 Aggregate', 
                key: 'productions', 
                route: '/productionManagements/productions',
                ImageUrl: '',
            },
            { 
                title: '물류', 
                description: '생산된 생선의 저장 및 배송 처리를 담당하는 Aggregate', 
                key: 'logistics', 
                route: '/logisticsManagements/logistics',
                ImageUrl: '',
            },
            { 
                title: '영업', 
                description: '영업 계약 및 주문 정보를 담당하는 Aggregate', 
                key: 'sales', 
                route: '/salesManagements/sales',
                ImageUrl: '',
            },
        ],
    }),
    methods: {
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
}
</script>

<style>
</style>
