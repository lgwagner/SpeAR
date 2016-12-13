package com.rockwellcollins.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.rockwellcollins.services.SpearGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSpearParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_EXT_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Specification'", "'Imports:'", "'Units:'", "'Types:'", "'Constants:'", "'Patterns:'", "'Inputs:'", "'Outputs:'", "'State:'", "'Macros:'", "':'", "'Assumptions'", "'Environment'", "'DerivedRequirements'", "'Requirements'", "'Implementation'", "'Design'", "'Constraints'", "'Properties'", "'Guarantees'", "'Behaviors'", "'import'", "'Definitions'", "'pattern'", "'('", "','", "')'", "'returns'", "'var'", "'let'", "'tel'", "'|'", "'='", "'--%PROPERTY'", "'assert'", "'*'", "'/'", "'abstract'", "'record'", "'{'", "'}'", "'['", "']'", "'enum'", "'int'", "'bool'", "'real'", "'is a'", "'is an'", "'text'", "'trace'", "'parents'", "'owner'", "'reviewDate'", "'source'", "'rationale'", "'comments'", "'while'", "'then'", "'=>'", "'implies'", "'or'", "'xor'", "'and'", "'after'", "'until'", "'T'", "'triggers'", "'S'", "'since'", "'O'", "'once'", "'H'", "'historically'", "'never'", "'before'", "'initially'", "'<'", "'less'", "'than'", "'<='", "'equal'", "'to'", "'>'", "'greater'", "'>='", "'=='", "'<>'", "'not'", "'+'", "'-'", "'mod'", "'->'", "'arrow'", "'previous'", "'with'", "'initial'", "'value'", "'.'", "':='", "'if'", "'else'", "'new'", "'spec'", "'#'", "'TRUE'", "'true'", "'FALSE'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_EXT_INT=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSpearParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSpearParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSpearParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSpear.g"; }



     	private SpearGrammarAccess grammarAccess;
     	
        public InternalSpearParser(TokenStream input, SpearGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected SpearGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // InternalSpear.g:67:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalSpear.g:68:2: (iv_ruleFile= ruleFile EOF )
            // InternalSpear.g:69:2: iv_ruleFile= ruleFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFile; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalSpear.g:76:1: ruleFile returns [EObject current=null] : (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions ) ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject this_Specification_0 = null;

        EObject this_Definitions_1 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:79:28: ( (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions ) )
            // InternalSpear.g:80:1: (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions )
            {
            // InternalSpear.g:80:1: (this_Specification_0= ruleSpecification | this_Definitions_1= ruleDefinitions )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==34) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalSpear.g:81:5: this_Specification_0= ruleSpecification
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFileAccess().getSpecificationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Specification_0=ruleSpecification();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Specification_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:91:5: this_Definitions_1= ruleDefinitions
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFileAccess().getDefinitionsParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Definitions_1=ruleDefinitions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Definitions_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleSpecification"
    // InternalSpear.g:107:1: entryRuleSpecification returns [EObject current=null] : iv_ruleSpecification= ruleSpecification EOF ;
    public final EObject entryRuleSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecification = null;


        try {
            // InternalSpear.g:108:2: (iv_ruleSpecification= ruleSpecification EOF )
            // InternalSpear.g:109:2: iv_ruleSpecification= ruleSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecificationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecification=ruleSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecification; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecification"


    // $ANTLR start "ruleSpecification"
    // InternalSpear.g:116:1: ruleSpecification returns [EObject current=null] : (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? otherlv_12= 'Inputs:' ( (lv_inputs_13_0= ruleVariable ) )* otherlv_14= 'Outputs:' ( (lv_outputs_15_0= ruleVariable ) )* (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )? (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )? ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )? ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) ) otherlv_24= ':' ( (lv_requirements_25_0= ruleConstraint ) )* ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )? ) ;
    public final EObject ruleSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_21=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        EObject lv_imports_3_0 = null;

        EObject lv_units_5_0 = null;

        EObject lv_typedefs_7_0 = null;

        EObject lv_constants_9_0 = null;

        EObject lv_patterns_11_0 = null;

        EObject lv_inputs_13_0 = null;

        EObject lv_outputs_15_0 = null;

        EObject lv_state_17_0 = null;

        EObject lv_macros_19_0 = null;

        AntlrDatatypeRuleToken lv_assumptionsKeyword_20_0 = null;

        EObject lv_assumptions_22_0 = null;

        AntlrDatatypeRuleToken lv_requirementsKeyword_23_0 = null;

        EObject lv_requirements_25_0 = null;

        AntlrDatatypeRuleToken lv_propertiesKeyword_26_0 = null;

        EObject lv_behaviors_28_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:119:28: ( (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? otherlv_12= 'Inputs:' ( (lv_inputs_13_0= ruleVariable ) )* otherlv_14= 'Outputs:' ( (lv_outputs_15_0= ruleVariable ) )* (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )? (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )? ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )? ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) ) otherlv_24= ':' ( (lv_requirements_25_0= ruleConstraint ) )* ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )? ) )
            // InternalSpear.g:120:1: (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? otherlv_12= 'Inputs:' ( (lv_inputs_13_0= ruleVariable ) )* otherlv_14= 'Outputs:' ( (lv_outputs_15_0= ruleVariable ) )* (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )? (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )? ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )? ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) ) otherlv_24= ':' ( (lv_requirements_25_0= ruleConstraint ) )* ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )? )
            {
            // InternalSpear.g:120:1: (otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? otherlv_12= 'Inputs:' ( (lv_inputs_13_0= ruleVariable ) )* otherlv_14= 'Outputs:' ( (lv_outputs_15_0= ruleVariable ) )* (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )? (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )? ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )? ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) ) otherlv_24= ':' ( (lv_requirements_25_0= ruleConstraint ) )* ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )? )
            // InternalSpear.g:120:3: otherlv_0= 'Specification' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? otherlv_12= 'Inputs:' ( (lv_inputs_13_0= ruleVariable ) )* otherlv_14= 'Outputs:' ( (lv_outputs_15_0= ruleVariable ) )* (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )? (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )? ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )? ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) ) otherlv_24= ':' ( (lv_requirements_25_0= ruleConstraint ) )* ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )?
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSpecificationAccess().getSpecificationKeyword_0());
                  
            }
            // InternalSpear.g:124:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpear.g:125:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSpear.g:125:1: (lv_name_1_0= RULE_ID )
            // InternalSpear.g:126:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getSpecificationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSpecificationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalSpear.g:142:2: (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSpear.g:142:4: otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )*
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
                          
                    }
                    // InternalSpear.g:146:1: ( (lv_imports_3_0= ruleImport ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==33) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalSpear.g:147:1: (lv_imports_3_0= ruleImport )
                    	    {
                    	    // InternalSpear.g:147:1: (lv_imports_3_0= ruleImport )
                    	    // InternalSpear.g:148:3: lv_imports_3_0= ruleImport
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getImportsImportParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_5);
                    	    lv_imports_3_0=ruleImport();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"imports",
                    	              		lv_imports_3_0, 
                    	              		"com.rockwellcollins.Spear.Import");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:164:5: (otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSpear.g:164:7: otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )*
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSpecificationAccess().getUnitsKeyword_3_0());
                          
                    }
                    // InternalSpear.g:168:1: ( (lv_units_5_0= ruleUnitDef ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSpear.g:169:1: (lv_units_5_0= ruleUnitDef )
                    	    {
                    	    // InternalSpear.g:169:1: (lv_units_5_0= ruleUnitDef )
                    	    // InternalSpear.g:170:3: lv_units_5_0= ruleUnitDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getUnitsUnitDefParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_6);
                    	    lv_units_5_0=ruleUnitDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"units",
                    	              		lv_units_5_0, 
                    	              		"com.rockwellcollins.Spear.UnitDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:186:5: (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSpear.g:186:7: otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSpecificationAccess().getTypesKeyword_4_0());
                          
                    }
                    // InternalSpear.g:190:1: ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSpear.g:191:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    {
                    	    // InternalSpear.g:191:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    // InternalSpear.g:192:3: lv_typedefs_7_0= ruleTypeDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getTypedefsTypeDefParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_typedefs_7_0=ruleTypeDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typedefs",
                    	              		lv_typedefs_7_0, 
                    	              		"com.rockwellcollins.Spear.TypeDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:208:5: (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSpear.g:208:7: otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )*
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSpecificationAccess().getConstantsKeyword_5_0());
                          
                    }
                    // InternalSpear.g:212:1: ( (lv_constants_9_0= ruleConstant ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSpear.g:213:1: (lv_constants_9_0= ruleConstant )
                    	    {
                    	    // InternalSpear.g:213:1: (lv_constants_9_0= ruleConstant )
                    	    // InternalSpear.g:214:3: lv_constants_9_0= ruleConstant
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getConstantsConstantParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_constants_9_0=ruleConstant();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constants",
                    	              		lv_constants_9_0, 
                    	              		"com.rockwellcollins.Spear.Constant");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:230:5: (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSpear.g:230:7: otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )*
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSpecificationAccess().getPatternsKeyword_6_0());
                          
                    }
                    // InternalSpear.g:234:1: ( (lv_patterns_11_0= rulePattern ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==35) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalSpear.g:235:1: (lv_patterns_11_0= rulePattern )
                    	    {
                    	    // InternalSpear.g:235:1: (lv_patterns_11_0= rulePattern )
                    	    // InternalSpear.g:236:3: lv_patterns_11_0= rulePattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getPatternsPatternParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_patterns_11_0=rulePattern();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"patterns",
                    	              		lv_patterns_11_0, 
                    	              		"com.rockwellcollins.Spear.Pattern");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getSpecificationAccess().getInputsKeyword_7());
                  
            }
            // InternalSpear.g:256:1: ( (lv_inputs_13_0= ruleVariable ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSpear.g:257:1: (lv_inputs_13_0= ruleVariable )
            	    {
            	    // InternalSpear.g:257:1: (lv_inputs_13_0= ruleVariable )
            	    // InternalSpear.g:258:3: lv_inputs_13_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getInputsVariableParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_inputs_13_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"inputs",
            	              		lv_inputs_13_0, 
            	              		"com.rockwellcollins.Spear.Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_14=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getSpecificationAccess().getOutputsKeyword_9());
                  
            }
            // InternalSpear.g:278:1: ( (lv_outputs_15_0= ruleVariable ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSpear.g:279:1: (lv_outputs_15_0= ruleVariable )
            	    {
            	    // InternalSpear.g:279:1: (lv_outputs_15_0= ruleVariable )
            	    // InternalSpear.g:280:3: lv_outputs_15_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getOutputsVariableParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_outputs_15_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"outputs",
            	              		lv_outputs_15_0, 
            	              		"com.rockwellcollins.Spear.Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalSpear.g:296:3: (otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSpear.g:296:5: otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )*
                    {
                    otherlv_16=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getSpecificationAccess().getStateKeyword_11_0());
                          
                    }
                    // InternalSpear.g:300:1: ( (lv_state_17_0= ruleVariable ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalSpear.g:301:1: (lv_state_17_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:301:1: (lv_state_17_0= ruleVariable )
                    	    // InternalSpear.g:302:3: lv_state_17_0= ruleVariable
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getStateVariableParserRuleCall_11_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_state_17_0=ruleVariable();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"state",
                    	              		lv_state_17_0, 
                    	              		"com.rockwellcollins.Spear.Variable");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:318:5: (otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==21) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSpear.g:318:7: otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )*
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getSpecificationAccess().getMacrosKeyword_12_0());
                          
                    }
                    // InternalSpear.g:322:1: ( (lv_macros_19_0= ruleMacro ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSpear.g:323:1: (lv_macros_19_0= ruleMacro )
                    	    {
                    	    // InternalSpear.g:323:1: (lv_macros_19_0= ruleMacro )
                    	    // InternalSpear.g:324:3: lv_macros_19_0= ruleMacro
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getMacrosMacroParserRuleCall_12_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_macros_19_0=ruleMacro();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"macros",
                    	              		lv_macros_19_0, 
                    	              		"com.rockwellcollins.Spear.Macro");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:340:5: ( ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=23 && LA19_0<=24)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSpear.g:340:6: ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) ) otherlv_21= ':' ( (lv_assumptions_22_0= ruleConstraint ) )*
                    {
                    // InternalSpear.g:340:6: ( (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader ) )
                    // InternalSpear.g:341:1: (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader )
                    {
                    // InternalSpear.g:341:1: (lv_assumptionsKeyword_20_0= ruleAssumptionsHeader )
                    // InternalSpear.g:342:3: lv_assumptionsKeyword_20_0= ruleAssumptionsHeader
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSpecificationAccess().getAssumptionsKeywordAssumptionsHeaderParserRuleCall_13_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    lv_assumptionsKeyword_20_0=ruleAssumptionsHeader();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                      	        }
                             		set(
                             			current, 
                             			"assumptionsKeyword",
                              		lv_assumptionsKeyword_20_0, 
                              		"com.rockwellcollins.Spear.AssumptionsHeader");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_21=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getSpecificationAccess().getColonKeyword_13_1());
                          
                    }
                    // InternalSpear.g:362:1: ( (lv_assumptions_22_0= ruleConstraint ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalSpear.g:363:1: (lv_assumptions_22_0= ruleConstraint )
                    	    {
                    	    // InternalSpear.g:363:1: (lv_assumptions_22_0= ruleConstraint )
                    	    // InternalSpear.g:364:3: lv_assumptions_22_0= ruleConstraint
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getAssumptionsConstraintParserRuleCall_13_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_assumptions_22_0=ruleConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assumptions",
                    	              		lv_assumptions_22_0, 
                    	              		"com.rockwellcollins.Spear.Constraint");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:380:5: ( (lv_requirementsKeyword_23_0= ruleRequirementsHeader ) )
            // InternalSpear.g:381:1: (lv_requirementsKeyword_23_0= ruleRequirementsHeader )
            {
            // InternalSpear.g:381:1: (lv_requirementsKeyword_23_0= ruleRequirementsHeader )
            // InternalSpear.g:382:3: lv_requirementsKeyword_23_0= ruleRequirementsHeader
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSpecificationAccess().getRequirementsKeywordRequirementsHeaderParserRuleCall_14_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
            lv_requirementsKeyword_23_0=ruleRequirementsHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"requirementsKeyword",
                      		lv_requirementsKeyword_23_0, 
                      		"com.rockwellcollins.Spear.RequirementsHeader");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_24=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_24, grammarAccess.getSpecificationAccess().getColonKeyword_15());
                  
            }
            // InternalSpear.g:402:1: ( (lv_requirements_25_0= ruleConstraint ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSpear.g:403:1: (lv_requirements_25_0= ruleConstraint )
            	    {
            	    // InternalSpear.g:403:1: (lv_requirements_25_0= ruleConstraint )
            	    // InternalSpear.g:404:3: lv_requirements_25_0= ruleConstraint
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getRequirementsConstraintParserRuleCall_16_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_requirements_25_0=ruleConstraint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requirements",
            	              		lv_requirements_25_0, 
            	              		"com.rockwellcollins.Spear.Constraint");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalSpear.g:420:3: ( ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26||(LA22_0>=30 && LA22_0<=32)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSpear.g:420:4: ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) ) otherlv_27= ':' ( (lv_behaviors_28_0= ruleConstraint ) )*
                    {
                    // InternalSpear.g:420:4: ( (lv_propertiesKeyword_26_0= rulePropertiesHeader ) )
                    // InternalSpear.g:421:1: (lv_propertiesKeyword_26_0= rulePropertiesHeader )
                    {
                    // InternalSpear.g:421:1: (lv_propertiesKeyword_26_0= rulePropertiesHeader )
                    // InternalSpear.g:422:3: lv_propertiesKeyword_26_0= rulePropertiesHeader
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSpecificationAccess().getPropertiesKeywordPropertiesHeaderParserRuleCall_17_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_12);
                    lv_propertiesKeyword_26_0=rulePropertiesHeader();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                      	        }
                             		set(
                             			current, 
                             			"propertiesKeyword",
                              		lv_propertiesKeyword_26_0, 
                              		"com.rockwellcollins.Spear.PropertiesHeader");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getSpecificationAccess().getColonKeyword_17_1());
                          
                    }
                    // InternalSpear.g:442:1: ( (lv_behaviors_28_0= ruleConstraint ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalSpear.g:443:1: (lv_behaviors_28_0= ruleConstraint )
                    	    {
                    	    // InternalSpear.g:443:1: (lv_behaviors_28_0= ruleConstraint )
                    	    // InternalSpear.g:444:3: lv_behaviors_28_0= ruleConstraint
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSpecificationAccess().getBehaviorsConstraintParserRuleCall_17_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_behaviors_28_0=ruleConstraint();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"behaviors",
                    	              		lv_behaviors_28_0, 
                    	              		"com.rockwellcollins.Spear.Constraint");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecification"


    // $ANTLR start "entryRuleAssumptionsHeader"
    // InternalSpear.g:468:1: entryRuleAssumptionsHeader returns [String current=null] : iv_ruleAssumptionsHeader= ruleAssumptionsHeader EOF ;
    public final String entryRuleAssumptionsHeader() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssumptionsHeader = null;


        try {
            // InternalSpear.g:469:2: (iv_ruleAssumptionsHeader= ruleAssumptionsHeader EOF )
            // InternalSpear.g:470:2: iv_ruleAssumptionsHeader= ruleAssumptionsHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssumptionsHeaderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssumptionsHeader=ruleAssumptionsHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssumptionsHeader.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssumptionsHeader"


    // $ANTLR start "ruleAssumptionsHeader"
    // InternalSpear.g:477:1: ruleAssumptionsHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Assumptions' | kw= 'Environment' ) ;
    public final AntlrDatatypeRuleToken ruleAssumptionsHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:480:28: ( (kw= 'Assumptions' | kw= 'Environment' ) )
            // InternalSpear.g:481:1: (kw= 'Assumptions' | kw= 'Environment' )
            {
            // InternalSpear.g:481:1: (kw= 'Assumptions' | kw= 'Environment' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            else if ( (LA23_0==24) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalSpear.g:482:2: kw= 'Assumptions'
                    {
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAssumptionsHeaderAccess().getAssumptionsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:489:2: kw= 'Environment'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAssumptionsHeaderAccess().getEnvironmentKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssumptionsHeader"


    // $ANTLR start "entryRuleRequirementsHeader"
    // InternalSpear.g:502:1: entryRuleRequirementsHeader returns [String current=null] : iv_ruleRequirementsHeader= ruleRequirementsHeader EOF ;
    public final String entryRuleRequirementsHeader() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRequirementsHeader = null;


        try {
            // InternalSpear.g:503:2: (iv_ruleRequirementsHeader= ruleRequirementsHeader EOF )
            // InternalSpear.g:504:2: iv_ruleRequirementsHeader= ruleRequirementsHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequirementsHeaderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequirementsHeader=ruleRequirementsHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequirementsHeader.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirementsHeader"


    // $ANTLR start "ruleRequirementsHeader"
    // InternalSpear.g:511:1: ruleRequirementsHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' ) ;
    public final AntlrDatatypeRuleToken ruleRequirementsHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:514:28: ( (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' ) )
            // InternalSpear.g:515:1: (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' )
            {
            // InternalSpear.g:515:1: (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt24=1;
                }
                break;
            case 26:
                {
                alt24=2;
                }
                break;
            case 27:
                {
                alt24=3;
                }
                break;
            case 28:
                {
                alt24=4;
                }
                break;
            case 29:
                {
                alt24=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSpear.g:516:2: kw= 'DerivedRequirements'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getDerivedRequirementsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:523:2: kw= 'Requirements'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getRequirementsKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:530:2: kw= 'Implementation'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getImplementationKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:537:2: kw= 'Design'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getDesignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpear.g:544:2: kw= 'Constraints'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getConstraintsKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequirementsHeader"


    // $ANTLR start "entryRulePropertiesHeader"
    // InternalSpear.g:557:1: entryRulePropertiesHeader returns [String current=null] : iv_rulePropertiesHeader= rulePropertiesHeader EOF ;
    public final String entryRulePropertiesHeader() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertiesHeader = null;


        try {
            // InternalSpear.g:558:2: (iv_rulePropertiesHeader= rulePropertiesHeader EOF )
            // InternalSpear.g:559:2: iv_rulePropertiesHeader= rulePropertiesHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertiesHeaderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertiesHeader=rulePropertiesHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertiesHeader.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertiesHeader"


    // $ANTLR start "rulePropertiesHeader"
    // InternalSpear.g:566:1: rulePropertiesHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'Behaviors' ) ;
    public final AntlrDatatypeRuleToken rulePropertiesHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:569:28: ( (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'Behaviors' ) )
            // InternalSpear.g:570:1: (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'Behaviors' )
            {
            // InternalSpear.g:570:1: (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'Behaviors' )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt25=1;
                }
                break;
            case 30:
                {
                alt25=2;
                }
                break;
            case 31:
                {
                alt25=3;
                }
                break;
            case 32:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalSpear.g:571:2: kw= 'Requirements'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getRequirementsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:578:2: kw= 'Properties'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getPropertiesKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:585:2: kw= 'Guarantees'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getGuaranteesKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:592:2: kw= 'Behaviors'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getBehaviorsKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertiesHeader"


    // $ANTLR start "entryRuleImport"
    // InternalSpear.g:605:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSpear.g:606:2: (iv_ruleImport= ruleImport EOF )
            // InternalSpear.g:607:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalSpear.g:614:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:617:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalSpear.g:618:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalSpear.g:618:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalSpear.g:618:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // InternalSpear.g:622:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalSpear.g:623:1: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalSpear.g:623:1: (lv_importURI_1_0= RULE_STRING )
            // InternalSpear.g:624:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getImportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDefinitions"
    // InternalSpear.g:648:1: entryRuleDefinitions returns [EObject current=null] : iv_ruleDefinitions= ruleDefinitions EOF ;
    public final EObject entryRuleDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitions = null;


        try {
            // InternalSpear.g:649:2: (iv_ruleDefinitions= ruleDefinitions EOF )
            // InternalSpear.g:650:2: iv_ruleDefinitions= ruleDefinitions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefinitions=ruleDefinitions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitions; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitions"


    // $ANTLR start "ruleDefinitions"
    // InternalSpear.g:657:1: ruleDefinitions returns [EObject current=null] : (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? ) ;
    public final EObject ruleDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_imports_3_0 = null;

        EObject lv_unitdefs_5_0 = null;

        EObject lv_typedefs_7_0 = null;

        EObject lv_constants_9_0 = null;

        EObject lv_patterns_11_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:660:28: ( (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? ) )
            // InternalSpear.g:661:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? )
            {
            // InternalSpear.g:661:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? )
            // InternalSpear.g:661:3: otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefinitionsAccess().getDefinitionsKeyword_0());
                  
            }
            // InternalSpear.g:665:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpear.g:666:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSpear.g:666:1: (lv_name_1_0= RULE_ID )
            // InternalSpear.g:667:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getDefinitionsAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefinitionsRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalSpear.g:683:2: (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSpear.g:683:4: otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )*
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefinitionsAccess().getImportsKeyword_2_0());
                          
                    }
                    // InternalSpear.g:687:1: ( (lv_imports_3_0= ruleImport ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==33) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalSpear.g:688:1: (lv_imports_3_0= ruleImport )
                    	    {
                    	    // InternalSpear.g:688:1: (lv_imports_3_0= ruleImport )
                    	    // InternalSpear.g:689:3: lv_imports_3_0= ruleImport
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getImportsImportParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_17);
                    	    lv_imports_3_0=ruleImport();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"imports",
                    	              		lv_imports_3_0, 
                    	              		"com.rockwellcollins.Spear.Import");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:705:5: (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==14) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSpear.g:705:7: otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )*
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDefinitionsAccess().getUnitsKeyword_3_0());
                          
                    }
                    // InternalSpear.g:709:1: ( (lv_unitdefs_5_0= ruleUnitDef ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalSpear.g:710:1: (lv_unitdefs_5_0= ruleUnitDef )
                    	    {
                    	    // InternalSpear.g:710:1: (lv_unitdefs_5_0= ruleUnitDef )
                    	    // InternalSpear.g:711:3: lv_unitdefs_5_0= ruleUnitDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getUnitdefsUnitDefParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_18);
                    	    lv_unitdefs_5_0=ruleUnitDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"unitdefs",
                    	              		lv_unitdefs_5_0, 
                    	              		"com.rockwellcollins.Spear.UnitDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:727:5: (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==15) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSpear.g:727:7: otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDefinitionsAccess().getTypesKeyword_4_0());
                          
                    }
                    // InternalSpear.g:731:1: ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalSpear.g:732:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    {
                    	    // InternalSpear.g:732:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    // InternalSpear.g:733:3: lv_typedefs_7_0= ruleTypeDef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getTypedefsTypeDefParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_typedefs_7_0=ruleTypeDef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"typedefs",
                    	              		lv_typedefs_7_0, 
                    	              		"com.rockwellcollins.Spear.TypeDef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:749:5: (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==16) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalSpear.g:749:7: otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )*
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDefinitionsAccess().getConstantsKeyword_5_0());
                          
                    }
                    // InternalSpear.g:753:1: ( (lv_constants_9_0= ruleConstant ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalSpear.g:754:1: (lv_constants_9_0= ruleConstant )
                    	    {
                    	    // InternalSpear.g:754:1: (lv_constants_9_0= ruleConstant )
                    	    // InternalSpear.g:755:3: lv_constants_9_0= ruleConstant
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getConstantsConstantParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_20);
                    	    lv_constants_9_0=ruleConstant();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constants",
                    	              		lv_constants_9_0, 
                    	              		"com.rockwellcollins.Spear.Constant");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSpear.g:771:5: (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSpear.g:771:7: otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )*
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getDefinitionsAccess().getPatternsKeyword_6_0());
                          
                    }
                    // InternalSpear.g:775:1: ( (lv_patterns_11_0= rulePattern ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==35) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalSpear.g:776:1: (lv_patterns_11_0= rulePattern )
                    	    {
                    	    // InternalSpear.g:776:1: (lv_patterns_11_0= rulePattern )
                    	    // InternalSpear.g:777:3: lv_patterns_11_0= rulePattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionsAccess().getPatternsPatternParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_patterns_11_0=rulePattern();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"patterns",
                    	              		lv_patterns_11_0, 
                    	              		"com.rockwellcollins.Spear.Pattern");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitions"


    // $ANTLR start "entryRulePattern"
    // InternalSpear.g:801:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalSpear.g:802:2: (iv_rulePattern= rulePattern EOF )
            // InternalSpear.g:803:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalSpear.g:810:1: rulePattern returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ( (lv_data_20_0= ruleData ) )* ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_19=null;
        EObject lv_inputs_3_0 = null;

        EObject lv_inputs_5_0 = null;

        EObject lv_outputs_9_0 = null;

        EObject lv_outputs_11_0 = null;

        EObject lv_locals_14_0 = null;

        EObject lv_equations_16_0 = null;

        EObject lv_properties_17_0 = null;

        EObject lv_assertions_18_0 = null;

        EObject lv_data_20_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:813:28: ( (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ( (lv_data_20_0= ruleData ) )* ) )
            // InternalSpear.g:814:1: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ( (lv_data_20_0= ruleData ) )* )
            {
            // InternalSpear.g:814:1: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ( (lv_data_20_0= ruleData ) )* )
            // InternalSpear.g:814:3: otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ( (lv_data_20_0= ruleData ) )*
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
                  
            }
            // InternalSpear.g:818:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpear.g:819:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSpear.g:819:1: (lv_name_1_0= RULE_ID )
            // InternalSpear.g:820:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPatternAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPatternRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpear.g:840:1: ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSpear.g:840:2: ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )*
                    {
                    // InternalSpear.g:840:2: ( (lv_inputs_3_0= ruleVariable ) )
                    // InternalSpear.g:841:1: (lv_inputs_3_0= ruleVariable )
                    {
                    // InternalSpear.g:841:1: (lv_inputs_3_0= ruleVariable )
                    // InternalSpear.g:842:3: lv_inputs_3_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternAccess().getInputsVariableParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_24);
                    lv_inputs_3_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternRule());
                      	        }
                             		add(
                             			current, 
                             			"inputs",
                              		lv_inputs_3_0, 
                              		"com.rockwellcollins.Spear.Variable");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:858:2: (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==37) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalSpear.g:858:4: otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalSpear.g:862:1: ( (lv_inputs_5_0= ruleVariable ) )
                    	    // InternalSpear.g:863:1: (lv_inputs_5_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:863:1: (lv_inputs_5_0= ruleVariable )
                    	    // InternalSpear.g:864:3: lv_inputs_5_0= ruleVariable
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPatternAccess().getInputsVariableParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_24);
                    	    lv_inputs_5_0=ruleVariable();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"inputs",
                    	              		lv_inputs_5_0, 
                    	              		"com.rockwellcollins.Spear.Variable");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,38,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getPatternAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,39,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getPatternAccess().getReturnsKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_6());
                  
            }
            // InternalSpear.g:892:1: ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalSpear.g:892:2: ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )*
                    {
                    // InternalSpear.g:892:2: ( (lv_outputs_9_0= ruleVariable ) )
                    // InternalSpear.g:893:1: (lv_outputs_9_0= ruleVariable )
                    {
                    // InternalSpear.g:893:1: (lv_outputs_9_0= ruleVariable )
                    // InternalSpear.g:894:3: lv_outputs_9_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternAccess().getOutputsVariableParserRuleCall_7_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_24);
                    lv_outputs_9_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternRule());
                      	        }
                             		add(
                             			current, 
                             			"outputs",
                              		lv_outputs_9_0, 
                              		"com.rockwellcollins.Spear.Variable");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:910:2: (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==37) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalSpear.g:910:4: otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) )
                    	    {
                    	    otherlv_10=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getPatternAccess().getCommaKeyword_7_1_0());
                    	          
                    	    }
                    	    // InternalSpear.g:914:1: ( (lv_outputs_11_0= ruleVariable ) )
                    	    // InternalSpear.g:915:1: (lv_outputs_11_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:915:1: (lv_outputs_11_0= ruleVariable )
                    	    // InternalSpear.g:916:3: lv_outputs_11_0= ruleVariable
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPatternAccess().getOutputsVariableParserRuleCall_7_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_24);
                    	    lv_outputs_11_0=ruleVariable();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"outputs",
                    	              		lv_outputs_11_0, 
                    	              		"com.rockwellcollins.Spear.Variable");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getPatternAccess().getRightParenthesisKeyword_8());
                  
            }
            // InternalSpear.g:936:1: (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==40) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSpear.g:936:3: otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )*
                    {
                    otherlv_13=(Token)match(input,40,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getPatternAccess().getVarKeyword_9_0());
                          
                    }
                    // InternalSpear.g:940:1: ( (lv_locals_14_0= ruleVariable ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalSpear.g:941:1: (lv_locals_14_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:941:1: (lv_locals_14_0= ruleVariable )
                    	    // InternalSpear.g:942:3: lv_locals_14_0= ruleVariable
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPatternAccess().getLocalsVariableParserRuleCall_9_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_27);
                    	    lv_locals_14_0=ruleVariable();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"locals",
                    	              		lv_locals_14_0, 
                    	              		"com.rockwellcollins.Spear.Variable");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,41,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getPatternAccess().getLetKeyword_10());
                  
            }
            // InternalSpear.g:962:1: ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )*
            loop42:
            do {
                int alt42=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                case 43:
                    {
                    alt42=1;
                    }
                    break;
                case 45:
                    {
                    alt42=2;
                    }
                    break;
                case 46:
                    {
                    alt42=3;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // InternalSpear.g:962:2: ( (lv_equations_16_0= ruleLustreEquation ) )
            	    {
            	    // InternalSpear.g:962:2: ( (lv_equations_16_0= ruleLustreEquation ) )
            	    // InternalSpear.g:963:1: (lv_equations_16_0= ruleLustreEquation )
            	    {
            	    // InternalSpear.g:963:1: (lv_equations_16_0= ruleLustreEquation )
            	    // InternalSpear.g:964:3: lv_equations_16_0= ruleLustreEquation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getEquationsLustreEquationParserRuleCall_11_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_equations_16_0=ruleLustreEquation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"equations",
            	              		lv_equations_16_0, 
            	              		"com.rockwellcollins.Spear.LustreEquation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpear.g:981:6: ( (lv_properties_17_0= ruleLustreProperty ) )
            	    {
            	    // InternalSpear.g:981:6: ( (lv_properties_17_0= ruleLustreProperty ) )
            	    // InternalSpear.g:982:1: (lv_properties_17_0= ruleLustreProperty )
            	    {
            	    // InternalSpear.g:982:1: (lv_properties_17_0= ruleLustreProperty )
            	    // InternalSpear.g:983:3: lv_properties_17_0= ruleLustreProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getPropertiesLustrePropertyParserRuleCall_11_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_properties_17_0=ruleLustreProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"properties",
            	              		lv_properties_17_0, 
            	              		"com.rockwellcollins.Spear.LustreProperty");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpear.g:1000:6: ( (lv_assertions_18_0= ruleLustreAssertion ) )
            	    {
            	    // InternalSpear.g:1000:6: ( (lv_assertions_18_0= ruleLustreAssertion ) )
            	    // InternalSpear.g:1001:1: (lv_assertions_18_0= ruleLustreAssertion )
            	    {
            	    // InternalSpear.g:1001:1: (lv_assertions_18_0= ruleLustreAssertion )
            	    // InternalSpear.g:1002:3: lv_assertions_18_0= ruleLustreAssertion
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getAssertionsLustreAssertionParserRuleCall_11_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_assertions_18_0=ruleLustreAssertion();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"assertions",
            	              		lv_assertions_18_0, 
            	              		"com.rockwellcollins.Spear.LustreAssertion");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_19=(Token)match(input,42,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_19, grammarAccess.getPatternAccess().getTelKeyword_12());
                  
            }
            // InternalSpear.g:1022:1: ( (lv_data_20_0= ruleData ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=61 && LA43_0<=68)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSpear.g:1023:1: (lv_data_20_0= ruleData )
            	    {
            	    // InternalSpear.g:1023:1: (lv_data_20_0= ruleData )
            	    // InternalSpear.g:1024:3: lv_data_20_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPatternAccess().getDataDataParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_20_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPatternRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_20_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleLustreEquation"
    // InternalSpear.g:1048:1: entryRuleLustreEquation returns [EObject current=null] : iv_ruleLustreEquation= ruleLustreEquation EOF ;
    public final EObject entryRuleLustreEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreEquation = null;


        try {
            // InternalSpear.g:1049:2: (iv_ruleLustreEquation= ruleLustreEquation EOF )
            // InternalSpear.g:1050:2: iv_ruleLustreEquation= ruleLustreEquation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLustreEquationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLustreEquation=ruleLustreEquation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLustreEquation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLustreEquation"


    // $ANTLR start "ruleLustreEquation"
    // InternalSpear.g:1057:1: ruleLustreEquation returns [EObject current=null] : ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) ) ;
    public final EObject ruleLustreEquation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_rhs_6_0 = null;

        EObject lv_rhs_9_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1060:28: ( ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) ) )
            // InternalSpear.g:1061:1: ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) )
            {
            // InternalSpear.g:1061:1: ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_ID) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalSpear.g:1061:2: (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:1061:2: (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) )
                    // InternalSpear.g:1061:4: otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) )
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLustreEquationAccess().getVerticalLineKeyword_0_0());
                          
                    }
                    // InternalSpear.g:1065:1: ( (otherlv_1= RULE_ID ) )
                    // InternalSpear.g:1066:1: (otherlv_1= RULE_ID )
                    {
                    // InternalSpear.g:1066:1: (otherlv_1= RULE_ID )
                    // InternalSpear.g:1067:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }

                    // InternalSpear.g:1078:2: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==37) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalSpear.g:1078:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getLustreEquationAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1082:1: ( (otherlv_3= RULE_ID ) )
                    	    // InternalSpear.g:1083:1: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalSpear.g:1083:1: (otherlv_3= RULE_ID )
                    	    // InternalSpear.g:1084:3: otherlv_3= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_3, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_0_2_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,43,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLustreEquationAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    otherlv_5=(Token)match(input,44,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getLustreEquationAccess().getEqualsSignKeyword_0_4());
                          
                    }
                    // InternalSpear.g:1103:1: ( (lv_rhs_6_0= ruleExpr ) )
                    // InternalSpear.g:1104:1: (lv_rhs_6_0= ruleExpr )
                    {
                    // InternalSpear.g:1104:1: (lv_rhs_6_0= ruleExpr )
                    // InternalSpear.g:1105:3: lv_rhs_6_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLustreEquationAccess().getRhsExprParserRuleCall_0_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_rhs_6_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLustreEquationRule());
                      	        }
                             		set(
                             			current, 
                             			"rhs",
                              		lv_rhs_6_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:1122:6: ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:1122:6: ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) )
                    // InternalSpear.g:1122:7: ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) )
                    {
                    // InternalSpear.g:1122:7: ( (otherlv_7= RULE_ID ) )
                    // InternalSpear.g:1123:1: (otherlv_7= RULE_ID )
                    {
                    // InternalSpear.g:1123:1: (otherlv_7= RULE_ID )
                    // InternalSpear.g:1124:3: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                      	        }
                              
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_7, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_1_0_0()); 
                      	
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,44,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getLustreEquationAccess().getEqualsSignKeyword_1_1());
                          
                    }
                    // InternalSpear.g:1139:1: ( (lv_rhs_9_0= ruleExpr ) )
                    // InternalSpear.g:1140:1: (lv_rhs_9_0= ruleExpr )
                    {
                    // InternalSpear.g:1140:1: (lv_rhs_9_0= ruleExpr )
                    // InternalSpear.g:1141:3: lv_rhs_9_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLustreEquationAccess().getRhsExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_rhs_9_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLustreEquationRule());
                      	        }
                             		set(
                             			current, 
                             			"rhs",
                              		lv_rhs_9_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLustreEquation"


    // $ANTLR start "entryRuleLustreProperty"
    // InternalSpear.g:1165:1: entryRuleLustreProperty returns [EObject current=null] : iv_ruleLustreProperty= ruleLustreProperty EOF ;
    public final EObject entryRuleLustreProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreProperty = null;


        try {
            // InternalSpear.g:1166:2: (iv_ruleLustreProperty= ruleLustreProperty EOF )
            // InternalSpear.g:1167:2: iv_ruleLustreProperty= ruleLustreProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLustrePropertyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLustreProperty=ruleLustreProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLustreProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLustreProperty"


    // $ANTLR start "ruleLustreProperty"
    // InternalSpear.g:1174:1: ruleLustreProperty returns [EObject current=null] : (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleLustreProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:1177:28: ( (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSpear.g:1178:1: (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSpear.g:1178:1: (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) )
            // InternalSpear.g:1178:3: otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLustrePropertyAccess().getPROPERTYKeyword_0());
                  
            }
            // InternalSpear.g:1182:1: ( (otherlv_1= RULE_ID ) )
            // InternalSpear.g:1183:1: (otherlv_1= RULE_ID )
            {
            // InternalSpear.g:1183:1: (otherlv_1= RULE_ID )
            // InternalSpear.g:1184:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLustrePropertyRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getLustrePropertyAccess().getPropertyIdVariableCrossReference_1_0()); 
              	
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLustreProperty"


    // $ANTLR start "entryRuleLustreAssertion"
    // InternalSpear.g:1203:1: entryRuleLustreAssertion returns [EObject current=null] : iv_ruleLustreAssertion= ruleLustreAssertion EOF ;
    public final EObject entryRuleLustreAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreAssertion = null;


        try {
            // InternalSpear.g:1204:2: (iv_ruleLustreAssertion= ruleLustreAssertion EOF )
            // InternalSpear.g:1205:2: iv_ruleLustreAssertion= ruleLustreAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLustreAssertionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLustreAssertion=ruleLustreAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLustreAssertion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLustreAssertion"


    // $ANTLR start "ruleLustreAssertion"
    // InternalSpear.g:1212:1: ruleLustreAssertion returns [EObject current=null] : (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) ) ;
    public final EObject ruleLustreAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_assertionExpr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1215:28: ( (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) ) )
            // InternalSpear.g:1216:1: (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) )
            {
            // InternalSpear.g:1216:1: (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) )
            // InternalSpear.g:1216:3: otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLustreAssertionAccess().getAssertKeyword_0());
                  
            }
            // InternalSpear.g:1220:1: ( (lv_assertionExpr_1_0= ruleExpr ) )
            // InternalSpear.g:1221:1: (lv_assertionExpr_1_0= ruleExpr )
            {
            // InternalSpear.g:1221:1: (lv_assertionExpr_1_0= ruleExpr )
            // InternalSpear.g:1222:3: lv_assertionExpr_1_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLustreAssertionAccess().getAssertionExprExprParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_assertionExpr_1_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLustreAssertionRule());
              	        }
                     		set(
                     			current, 
                     			"assertionExpr",
                      		lv_assertionExpr_1_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLustreAssertion"


    // $ANTLR start "entryRuleUnitDef"
    // InternalSpear.g:1246:1: entryRuleUnitDef returns [EObject current=null] : iv_ruleUnitDef= ruleUnitDef EOF ;
    public final EObject entryRuleUnitDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitDef = null;


        try {
            // InternalSpear.g:1247:2: (iv_ruleUnitDef= ruleUnitDef EOF )
            // InternalSpear.g:1248:2: iv_ruleUnitDef= ruleUnitDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitDef=ruleUnitDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitDef"


    // $ANTLR start "ruleUnitDef"
    // InternalSpear.g:1255:1: ruleUnitDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) ;
    public final EObject ruleUnitDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_description_2_0=null;
        Token lv_name_4_0=null;
        Token lv_description_7_0=null;
        EObject lv_unit_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1258:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) )
            // InternalSpear.g:1259:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            {
            // InternalSpear.g:1259:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==EOF||(LA48_1>=RULE_ID && LA48_1<=RULE_STRING)||(LA48_1>=15 && LA48_1<=18)) ) {
                    alt48=1;
                }
                else if ( (LA48_1==22||(LA48_1>=59 && LA48_1<=60)) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalSpear.g:1259:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    {
                    // InternalSpear.g:1259:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    // InternalSpear.g:1259:3: () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )?
                    {
                    // InternalSpear.g:1259:3: ()
                    // InternalSpear.g:1260:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getBaseUnitAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1265:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpear.g:1266:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpear.g:1266:1: (lv_name_1_0= RULE_ID )
                    // InternalSpear.g:1267:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getUnitDefAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1283:2: ( (lv_description_2_0= RULE_STRING ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_STRING) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalSpear.g:1284:1: (lv_description_2_0= RULE_STRING )
                            {
                            // InternalSpear.g:1284:1: (lv_description_2_0= RULE_STRING )
                            // InternalSpear.g:1285:3: lv_description_2_0= RULE_STRING
                            {
                            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_2_0, grammarAccess.getUnitDefAccess().getDescriptionSTRINGTerminalRuleCall_0_2_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitDefRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_2_0, 
                                      		"org.eclipse.xtext.common.Terminals.STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:1302:6: ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    {
                    // InternalSpear.g:1302:6: ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    // InternalSpear.g:1302:7: () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )?
                    {
                    // InternalSpear.g:1302:7: ()
                    // InternalSpear.g:1303:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getDerivedUnitAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1308:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalSpear.g:1309:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalSpear.g:1309:1: (lv_name_4_0= RULE_ID )
                    // InternalSpear.g:1310:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getUnitDefAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnitDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnitDefAccess().getIdTypeDelimiterParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_35);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1334:1: ( (lv_unit_6_0= ruleUnitExpr ) )
                    // InternalSpear.g:1335:1: (lv_unit_6_0= ruleUnitExpr )
                    {
                    // InternalSpear.g:1335:1: (lv_unit_6_0= ruleUnitExpr )
                    // InternalSpear.g:1336:3: lv_unit_6_0= ruleUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnitDefAccess().getUnitUnitExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_unit_6_0=ruleUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnitDefRule());
                      	        }
                             		set(
                             			current, 
                             			"unit",
                              		lv_unit_6_0, 
                              		"com.rockwellcollins.Spear.UnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1352:2: ( (lv_description_7_0= RULE_STRING ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==RULE_STRING) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalSpear.g:1353:1: (lv_description_7_0= RULE_STRING )
                            {
                            // InternalSpear.g:1353:1: (lv_description_7_0= RULE_STRING )
                            // InternalSpear.g:1354:3: lv_description_7_0= RULE_STRING
                            {
                            lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_7_0, grammarAccess.getUnitDefAccess().getDescriptionSTRINGTerminalRuleCall_1_4_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnitDefRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_7_0, 
                                      		"org.eclipse.xtext.common.Terminals.STRING");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitDef"


    // $ANTLR start "entryRuleUnitExpr"
    // InternalSpear.g:1378:1: entryRuleUnitExpr returns [EObject current=null] : iv_ruleUnitExpr= ruleUnitExpr EOF ;
    public final EObject entryRuleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpr = null;


        try {
            // InternalSpear.g:1379:2: (iv_ruleUnitExpr= ruleUnitExpr EOF )
            // InternalSpear.g:1380:2: iv_ruleUnitExpr= ruleUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitExpr=ruleUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitExpr"


    // $ANTLR start "ruleUnitExpr"
    // InternalSpear.g:1387:1: ruleUnitExpr returns [EObject current=null] : this_ProductUnitExpr_0= ruleProductUnitExpr ;
    public final EObject ruleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ProductUnitExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1390:28: (this_ProductUnitExpr_0= ruleProductUnitExpr )
            // InternalSpear.g:1392:5: this_ProductUnitExpr_0= ruleProductUnitExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitExprAccess().getProductUnitExprParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_ProductUnitExpr_0=ruleProductUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ProductUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitExpr"


    // $ANTLR start "entryRuleProductUnitExpr"
    // InternalSpear.g:1408:1: entryRuleProductUnitExpr returns [EObject current=null] : iv_ruleProductUnitExpr= ruleProductUnitExpr EOF ;
    public final EObject entryRuleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductUnitExpr = null;


        try {
            // InternalSpear.g:1409:2: (iv_ruleProductUnitExpr= ruleProductUnitExpr EOF )
            // InternalSpear.g:1410:2: iv_ruleProductUnitExpr= ruleProductUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductUnitExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProductUnitExpr=ruleProductUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductUnitExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductUnitExpr"


    // $ANTLR start "ruleProductUnitExpr"
    // InternalSpear.g:1417:1: ruleProductUnitExpr returns [EObject current=null] : (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) ;
    public final EObject ruleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_DivisionUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1420:28: ( (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) )
            // InternalSpear.g:1421:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            {
            // InternalSpear.g:1421:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            // InternalSpear.g:1422:5: this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getProductUnitExprAccess().getDivisionUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_36);
            this_DivisionUnitExpr_0=ruleDivisionUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_DivisionUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:1430:1: ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==47) && (synpred1_InternalSpear())) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalSpear.g:1430:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) )
                    {
                    // InternalSpear.g:1430:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) )
                    // InternalSpear.g:1430:3: ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) )
                    {
                    // InternalSpear.g:1437:6: ( () ( (lv_op_2_0= '*' ) ) )
                    // InternalSpear.g:1437:7: () ( (lv_op_2_0= '*' ) )
                    {
                    // InternalSpear.g:1437:7: ()
                    // InternalSpear.g:1438:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getProductUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1443:2: ( (lv_op_2_0= '*' ) )
                    // InternalSpear.g:1444:1: (lv_op_2_0= '*' )
                    {
                    // InternalSpear.g:1444:1: (lv_op_2_0= '*' )
                    // InternalSpear.g:1445:3: lv_op_2_0= '*'
                    {
                    lv_op_2_0=(Token)match(input,47,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getProductUnitExprAccess().getOpAsteriskKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getProductUnitExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "*");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalSpear.g:1458:4: ( (lv_right_3_0= ruleProductUnitExpr ) )
                    // InternalSpear.g:1459:1: (lv_right_3_0= ruleProductUnitExpr )
                    {
                    // InternalSpear.g:1459:1: (lv_right_3_0= ruleProductUnitExpr )
                    // InternalSpear.g:1460:3: lv_right_3_0= ruleProductUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProductUnitExprAccess().getRightProductUnitExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleProductUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProductUnitExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.ProductUnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductUnitExpr"


    // $ANTLR start "entryRuleDivisionUnitExpr"
    // InternalSpear.g:1484:1: entryRuleDivisionUnitExpr returns [EObject current=null] : iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF ;
    public final EObject entryRuleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivisionUnitExpr = null;


        try {
            // InternalSpear.g:1485:2: (iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF )
            // InternalSpear.g:1486:2: iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDivisionUnitExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDivisionUnitExpr=ruleDivisionUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDivisionUnitExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivisionUnitExpr"


    // $ANTLR start "ruleDivisionUnitExpr"
    // InternalSpear.g:1493:1: ruleDivisionUnitExpr returns [EObject current=null] : (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) ;
    public final EObject ruleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AtomicUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1496:28: ( (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) )
            // InternalSpear.g:1497:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            {
            // InternalSpear.g:1497:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            // InternalSpear.g:1498:5: this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDivisionUnitExprAccess().getAtomicUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_37);
            this_AtomicUnitExpr_0=ruleAtomicUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:1506:1: ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==48) && (synpred2_InternalSpear())) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalSpear.g:1506:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    {
                    // InternalSpear.g:1506:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) )
                    // InternalSpear.g:1506:3: ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) )
                    {
                    // InternalSpear.g:1513:6: ( () ( (lv_op_2_0= '/' ) ) )
                    // InternalSpear.g:1513:7: () ( (lv_op_2_0= '/' ) )
                    {
                    // InternalSpear.g:1513:7: ()
                    // InternalSpear.g:1514:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getDivisionUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1519:2: ( (lv_op_2_0= '/' ) )
                    // InternalSpear.g:1520:1: (lv_op_2_0= '/' )
                    {
                    // InternalSpear.g:1520:1: (lv_op_2_0= '/' )
                    // InternalSpear.g:1521:3: lv_op_2_0= '/'
                    {
                    lv_op_2_0=(Token)match(input,48,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getDivisionUnitExprAccess().getOpSolidusKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDivisionUnitExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "/");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalSpear.g:1534:4: ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    // InternalSpear.g:1535:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    {
                    // InternalSpear.g:1535:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    // InternalSpear.g:1536:3: lv_right_3_0= ruleAtomicUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDivisionUnitExprAccess().getRightAtomicUnitExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAtomicUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDivisionUnitExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.AtomicUnitExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivisionUnitExpr"


    // $ANTLR start "entryRuleAtomicUnitExpr"
    // InternalSpear.g:1560:1: entryRuleAtomicUnitExpr returns [EObject current=null] : iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF ;
    public final EObject entryRuleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicUnitExpr = null;


        try {
            // InternalSpear.g:1561:2: (iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF )
            // InternalSpear.g:1562:2: iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicUnitExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomicUnitExpr=ruleAtomicUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicUnitExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicUnitExpr"


    // $ANTLR start "ruleAtomicUnitExpr"
    // InternalSpear.g:1569:1: ruleAtomicUnitExpr returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) ;
    public final EObject ruleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_UnitExpr_3 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1572:28: ( ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) )
            // InternalSpear.g:1573:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            {
            // InternalSpear.g:1573:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==36) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalSpear.g:1573:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    {
                    // InternalSpear.g:1573:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    // InternalSpear.g:1573:3: () ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalSpear.g:1573:3: ()
                    // InternalSpear.g:1574:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicUnitExprAccess().getNamedUnitExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1579:2: ( (otherlv_1= RULE_ID ) )
                    // InternalSpear.g:1580:1: (otherlv_1= RULE_ID )
                    {
                    // InternalSpear.g:1580:1: (otherlv_1= RULE_ID )
                    // InternalSpear.g:1581:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicUnitExprRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getAtomicUnitExprAccess().getUnitUnitDefCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:1593:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    {
                    // InternalSpear.g:1593:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    // InternalSpear.g:1593:8: otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicUnitExprAccess().getUnitExprParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_38);
                    this_UnitExpr_3=ruleUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnitExpr_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_4=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicUnitExprAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicUnitExpr"


    // $ANTLR start "entryRuleTypeDef"
    // InternalSpear.g:1618:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalSpear.g:1619:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalSpear.g:1620:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDef"


    // $ANTLR start "ruleTypeDef"
    // InternalSpear.g:1627:1: ruleTypeDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' ) | ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' ) | ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' ) | ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' ) ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_8=null;
        Token lv_name_10_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_name_19_0=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token lv_name_26_0=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        EObject lv_type_3_0 = null;

        EObject lv_fields_14_0 = null;

        EObject lv_fields_16_0 = null;

        EObject lv_base_21_0 = null;

        EObject lv_size_23_0 = null;

        EObject lv_values_30_0 = null;

        EObject lv_values_32_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1630:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' ) | ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' ) | ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' ) | ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' ) ) )
            // InternalSpear.g:1631:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' ) | ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' ) | ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' ) | ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' ) )
            {
            // InternalSpear.g:1631:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' ) | ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' ) | ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' ) | ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' ) )
            int alt55=5;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalSpear.g:1631:2: ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    {
                    // InternalSpear.g:1631:2: ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    // InternalSpear.g:1631:3: () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )?
                    {
                    // InternalSpear.g:1631:3: ()
                    // InternalSpear.g:1632:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getNamedTypeDefAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1637:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpear.g:1638:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpear.g:1638:1: (lv_name_1_0= RULE_ID )
                    // InternalSpear.g:1639:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_39);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1663:1: ( (lv_type_3_0= ruleType ) )
                    // InternalSpear.g:1664:1: (lv_type_3_0= ruleType )
                    {
                    // InternalSpear.g:1664:1: (lv_type_3_0= ruleType )
                    // InternalSpear.g:1665:3: lv_type_3_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_type_3_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"com.rockwellcollins.Spear.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1681:2: ( (otherlv_4= RULE_ID ) )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==RULE_ID) ) {
                        int LA52_1 = input.LA(2);

                        if ( (LA52_1==EOF||LA52_1==RULE_ID||(LA52_1>=16 && LA52_1<=18)) ) {
                            alt52=1;
                        }
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalSpear.g:1682:1: (otherlv_4= RULE_ID )
                            {
                            // InternalSpear.g:1682:1: (otherlv_4= RULE_ID )
                            // InternalSpear.g:1683:3: otherlv_4= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeDefRule());
                              	        }
                                      
                            }
                            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_4, grammarAccess.getTypeDefAccess().getUnitUnitDefCrossReference_0_4_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:1695:6: ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' )
                    {
                    // InternalSpear.g:1695:6: ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' )
                    // InternalSpear.g:1695:7: () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract'
                    {
                    // InternalSpear.g:1695:7: ()
                    // InternalSpear.g:1696:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getAbstractTypeDefAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1701:2: ( (lv_name_6_0= RULE_ID ) )
                    // InternalSpear.g:1702:1: (lv_name_6_0= RULE_ID )
                    {
                    // InternalSpear.g:1702:1: (lv_name_6_0= RULE_ID )
                    // InternalSpear.g:1703:3: lv_name_6_0= RULE_ID
                    {
                    lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_6_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_6_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_40);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTypeDefAccess().getAbstractKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:1732:6: ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' )
                    {
                    // InternalSpear.g:1732:6: ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' )
                    // InternalSpear.g:1732:7: () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}'
                    {
                    // InternalSpear.g:1732:7: ()
                    // InternalSpear.g:1733:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getRecordTypeDefAction_2_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1738:2: ( (lv_name_10_0= RULE_ID ) )
                    // InternalSpear.g:1739:1: (lv_name_10_0= RULE_ID )
                    {
                    // InternalSpear.g:1739:1: (lv_name_10_0= RULE_ID )
                    // InternalSpear.g:1740:3: lv_name_10_0= RULE_ID
                    {
                    lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_10_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_10_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_2_2()); 
                          
                    }
                    pushFollow(FOLLOW_41);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,50,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getTypeDefAccess().getRecordKeyword_2_3());
                          
                    }
                    otherlv_13=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_2_4());
                          
                    }
                    // InternalSpear.g:1772:1: ( (lv_fields_14_0= ruleFieldType ) )
                    // InternalSpear.g:1773:1: (lv_fields_14_0= ruleFieldType )
                    {
                    // InternalSpear.g:1773:1: (lv_fields_14_0= ruleFieldType )
                    // InternalSpear.g:1774:3: lv_fields_14_0= ruleFieldType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsFieldTypeParserRuleCall_2_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
                    lv_fields_14_0=ruleFieldType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_14_0, 
                              		"com.rockwellcollins.Spear.FieldType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1790:2: (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==37) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalSpear.g:1790:4: otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) )
                    	    {
                    	    otherlv_15=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_15, grammarAccess.getTypeDefAccess().getCommaKeyword_2_6_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1794:1: ( (lv_fields_16_0= ruleFieldType ) )
                    	    // InternalSpear.g:1795:1: (lv_fields_16_0= ruleFieldType )
                    	    {
                    	    // InternalSpear.g:1795:1: (lv_fields_16_0= ruleFieldType )
                    	    // InternalSpear.g:1796:3: lv_fields_16_0= ruleFieldType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsFieldTypeParserRuleCall_2_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_fields_16_0=ruleFieldType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_16_0, 
                    	              		"com.rockwellcollins.Spear.FieldType");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_2_7());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:1817:6: ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' )
                    {
                    // InternalSpear.g:1817:6: ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' )
                    // InternalSpear.g:1817:7: () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']'
                    {
                    // InternalSpear.g:1817:7: ()
                    // InternalSpear.g:1818:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getArrayTypeDefAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1823:2: ( (lv_name_19_0= RULE_ID ) )
                    // InternalSpear.g:1824:1: (lv_name_19_0= RULE_ID )
                    {
                    // InternalSpear.g:1824:1: (lv_name_19_0= RULE_ID )
                    // InternalSpear.g:1825:3: lv_name_19_0= RULE_ID
                    {
                    lv_name_19_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_19_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_19_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_3_2()); 
                          
                    }
                    pushFollow(FOLLOW_39);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1849:1: ( (lv_base_21_0= ruleType ) )
                    // InternalSpear.g:1850:1: (lv_base_21_0= ruleType )
                    {
                    // InternalSpear.g:1850:1: (lv_base_21_0= ruleType )
                    // InternalSpear.g:1851:3: lv_base_21_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getBaseTypeParserRuleCall_3_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_base_21_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"base",
                              		lv_base_21_0, 
                              		"com.rockwellcollins.Spear.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_22=(Token)match(input,53,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getTypeDefAccess().getLeftSquareBracketKeyword_3_4());
                          
                    }
                    // InternalSpear.g:1871:1: ( (lv_size_23_0= ruleExpr ) )
                    // InternalSpear.g:1872:1: (lv_size_23_0= ruleExpr )
                    {
                    // InternalSpear.g:1872:1: (lv_size_23_0= ruleExpr )
                    // InternalSpear.g:1873:3: lv_size_23_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getSizeExprParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_45);
                    lv_size_23_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"size",
                              		lv_size_23_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_24=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getTypeDefAccess().getRightSquareBracketKeyword_3_6());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSpear.g:1894:6: ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' )
                    {
                    // InternalSpear.g:1894:6: ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' )
                    // InternalSpear.g:1894:7: () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}'
                    {
                    // InternalSpear.g:1894:7: ()
                    // InternalSpear.g:1895:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getEnumTypeDefAction_4_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1900:2: ( (lv_name_26_0= RULE_ID ) )
                    // InternalSpear.g:1901:1: (lv_name_26_0= RULE_ID )
                    {
                    // InternalSpear.g:1901:1: (lv_name_26_0= RULE_ID )
                    // InternalSpear.g:1902:3: lv_name_26_0= RULE_ID
                    {
                    lv_name_26_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_26_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_26_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_4_2()); 
                          
                    }
                    pushFollow(FOLLOW_46);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_28=(Token)match(input,55,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getTypeDefAccess().getEnumKeyword_4_3());
                          
                    }
                    otherlv_29=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_4_4());
                          
                    }
                    // InternalSpear.g:1934:1: ( (lv_values_30_0= ruleEnumValue ) )
                    // InternalSpear.g:1935:1: (lv_values_30_0= ruleEnumValue )
                    {
                    // InternalSpear.g:1935:1: (lv_values_30_0= ruleEnumValue )
                    // InternalSpear.g:1936:3: lv_values_30_0= ruleEnumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_4_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
                    lv_values_30_0=ruleEnumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"values",
                              		lv_values_30_0, 
                              		"com.rockwellcollins.Spear.EnumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1952:2: (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==37) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalSpear.g:1952:4: otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) )
                    	    {
                    	    otherlv_31=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_31, grammarAccess.getTypeDefAccess().getCommaKeyword_4_6_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1956:1: ( (lv_values_32_0= ruleEnumValue ) )
                    	    // InternalSpear.g:1957:1: (lv_values_32_0= ruleEnumValue )
                    	    {
                    	    // InternalSpear.g:1957:1: (lv_values_32_0= ruleEnumValue )
                    	    // InternalSpear.g:1958:3: lv_values_32_0= ruleEnumValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_4_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_values_32_0=ruleEnumValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"values",
                    	              		lv_values_32_0, 
                    	              		"com.rockwellcollins.Spear.EnumValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_33=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_4_7());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDef"


    // $ANTLR start "entryRuleFieldType"
    // InternalSpear.g:1988:1: entryRuleFieldType returns [EObject current=null] : iv_ruleFieldType= ruleFieldType EOF ;
    public final EObject entryRuleFieldType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldType = null;


        try {
            // InternalSpear.g:1989:2: (iv_ruleFieldType= ruleFieldType EOF )
            // InternalSpear.g:1990:2: iv_ruleFieldType= ruleFieldType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFieldType=ruleFieldType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldType"


    // $ANTLR start "ruleFieldType"
    // InternalSpear.g:1997:1: ruleFieldType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleFieldType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2000:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) )
            // InternalSpear.g:2001:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalSpear.g:2001:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            // InternalSpear.g:2001:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) )
            {
            // InternalSpear.g:2001:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2002:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2002:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2003:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFieldTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldTypeAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:2023:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2024:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2024:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2025:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.Spear.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldType"


    // $ANTLR start "entryRuleEnumValue"
    // InternalSpear.g:2049:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalSpear.g:2050:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalSpear.g:2051:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // InternalSpear.g:2058:1: ruleEnumValue returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2061:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSpear.g:2062:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSpear.g:2062:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2063:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2063:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2064:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnumValueAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumValueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleType"
    // InternalSpear.g:2088:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSpear.g:2089:2: (iv_ruleType= ruleType EOF )
            // InternalSpear.g:2090:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalSpear.g:2097:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2100:28: ( ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalSpear.g:2101:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalSpear.g:2101:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt56=1;
                }
                break;
            case 57:
                {
                alt56=2;
                }
                break;
            case 58:
                {
                alt56=3;
                }
                break;
            case RULE_ID:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalSpear.g:2101:2: ( () otherlv_1= 'int' )
                    {
                    // InternalSpear.g:2101:2: ( () otherlv_1= 'int' )
                    // InternalSpear.g:2101:3: () otherlv_1= 'int'
                    {
                    // InternalSpear.g:2101:3: ()
                    // InternalSpear.g:2102:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getIntTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getIntKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:2112:6: ( () otherlv_3= 'bool' )
                    {
                    // InternalSpear.g:2112:6: ( () otherlv_3= 'bool' )
                    // InternalSpear.g:2112:7: () otherlv_3= 'bool'
                    {
                    // InternalSpear.g:2112:7: ()
                    // InternalSpear.g:2113:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getBoolTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getBoolKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:2123:6: ( () otherlv_5= 'real' )
                    {
                    // InternalSpear.g:2123:6: ( () otherlv_5= 'real' )
                    // InternalSpear.g:2123:7: () otherlv_5= 'real'
                    {
                    // InternalSpear.g:2123:7: ()
                    // InternalSpear.g:2124:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getRealTypeAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getRealKeyword_2_1());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:2134:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSpear.g:2134:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalSpear.g:2134:7: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalSpear.g:2134:7: ()
                    // InternalSpear.g:2135:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getUserTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2140:2: ( (otherlv_7= RULE_ID ) )
                    // InternalSpear.g:2141:1: (otherlv_7= RULE_ID )
                    {
                    // InternalSpear.g:2141:1: (otherlv_7= RULE_ID )
                    // InternalSpear.g:2142:3: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                              
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getDefTypeDefCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleIdTypeDelimiter"
    // InternalSpear.g:2161:1: entryRuleIdTypeDelimiter returns [String current=null] : iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF ;
    public final String entryRuleIdTypeDelimiter() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdTypeDelimiter = null;


        try {
            // InternalSpear.g:2162:2: (iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF )
            // InternalSpear.g:2163:2: iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdTypeDelimiterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdTypeDelimiter=ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdTypeDelimiter.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdTypeDelimiter"


    // $ANTLR start "ruleIdTypeDelimiter"
    // InternalSpear.g:2170:1: ruleIdTypeDelimiter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ':' | kw= 'is a' | kw= 'is an' ) ;
    public final AntlrDatatypeRuleToken ruleIdTypeDelimiter() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2173:28: ( (kw= ':' | kw= 'is a' | kw= 'is an' ) )
            // InternalSpear.g:2174:1: (kw= ':' | kw= 'is a' | kw= 'is an' )
            {
            // InternalSpear.g:2174:1: (kw= ':' | kw= 'is a' | kw= 'is an' )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt57=1;
                }
                break;
            case 59:
                {
                alt57=2;
                }
                break;
            case 60:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalSpear.g:2175:2: kw= ':'
                    {
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdTypeDelimiterAccess().getColonKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:2182:2: kw= 'is a'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdTypeDelimiterAccess().getIsAKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:2189:2: kw= 'is an'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdTypeDelimiterAccess().getIsAnKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdTypeDelimiter"


    // $ANTLR start "entryRuleConstant"
    // InternalSpear.g:2202:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSpear.g:2203:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalSpear.g:2204:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalSpear.g:2211:1: ruleConstant returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_data_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2214:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* ) )
            // InternalSpear.g:2215:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* )
            {
            // InternalSpear.g:2215:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* )
            // InternalSpear.g:2215:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )*
            {
            // InternalSpear.g:2215:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2216:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2216:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2217:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getConstantAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConstantAccess().getIdTypeDelimiterParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_39);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2241:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2242:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2242:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2243:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.Spear.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,44,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getConstantAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalSpear.g:2263:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalSpear.g:2264:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalSpear.g:2264:1: (lv_expr_4_0= ruleExpr )
            // InternalSpear.g:2265:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpear.g:2281:2: ( (lv_data_5_0= ruleData ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=61 && LA58_0<=68)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalSpear.g:2282:1: (lv_data_5_0= ruleData )
            	    {
            	    // InternalSpear.g:2282:1: (lv_data_5_0= ruleData )
            	    // InternalSpear.g:2283:3: lv_data_5_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstantAccess().getDataDataParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_5_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConstantRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_5_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // InternalSpear.g:2307:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSpear.g:2308:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalSpear.g:2309:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalSpear.g:2316:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ( (lv_data_3_0= ruleData ) )* ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_data_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2319:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ( (lv_data_3_0= ruleData ) )* ) )
            // InternalSpear.g:2320:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ( (lv_data_3_0= ruleData ) )* )
            {
            // InternalSpear.g:2320:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ( (lv_data_3_0= ruleData ) )* )
            // InternalSpear.g:2320:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ( (lv_data_3_0= ruleData ) )*
            {
            // InternalSpear.g:2320:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2321:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2321:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2322:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getVariableAccess().getIdTypeDelimiterParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_39);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2346:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2347:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2347:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2348:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.Spear.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpear.g:2364:2: ( (lv_data_3_0= ruleData ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=61 && LA59_0<=68)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalSpear.g:2365:1: (lv_data_3_0= ruleData )
            	    {
            	    // InternalSpear.g:2365:1: (lv_data_3_0= ruleData )
            	    // InternalSpear.g:2366:3: lv_data_3_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableAccess().getDataDataParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_3_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariableRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_3_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleMacro"
    // InternalSpear.g:2390:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalSpear.g:2391:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalSpear.g:2392:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // InternalSpear.g:2399:1: ruleMacro returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_data_5_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2402:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* ) )
            // InternalSpear.g:2403:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* )
            {
            // InternalSpear.g:2403:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )* )
            // InternalSpear.g:2403:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) ( (lv_data_5_0= ruleData ) )*
            {
            // InternalSpear.g:2403:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2404:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2404:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2405:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getMacroAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMacroAccess().getIdTypeDelimiterParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_39);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2429:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2430:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2430:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2431:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_31);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.Spear.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,44,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalSpear.g:2451:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalSpear.g:2452:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalSpear.g:2452:1: (lv_expr_4_0= ruleExpr )
            // InternalSpear.g:2453:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpear.g:2469:2: ( (lv_data_5_0= ruleData ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=61 && LA60_0<=68)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalSpear.g:2470:1: (lv_data_5_0= ruleData )
            	    {
            	    // InternalSpear.g:2470:1: (lv_data_5_0= ruleData )
            	    // InternalSpear.g:2471:3: lv_data_5_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getDataDataParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_5_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_5_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleConstraint"
    // InternalSpear.g:2495:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalSpear.g:2496:2: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalSpear.g:2497:2: iv_ruleConstraint= ruleConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalSpear.g:2504:1: ruleConstraint returns [EObject current=null] : (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_FormalConstraint_0 = null;

        EObject this_EnglishConstraint_1 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2507:28: ( (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) )
            // InternalSpear.g:2508:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            {
            // InternalSpear.g:2508:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==22) ) {
                    int LA61_2 = input.LA(3);

                    if ( (LA61_2==RULE_STRING) ) {
                        alt61=2;
                    }
                    else if ( (LA61_2==RULE_ID||LA61_2==RULE_INT||LA61_2==36||LA61_2==43||LA61_2==69||LA61_2==76||(LA61_2>=82 && LA61_2<=88)||LA61_2==100||LA61_2==102||LA61_2==106||LA61_2==112||(LA61_2>=114 && LA61_2<=120)) ) {
                        alt61=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalSpear.g:2509:5: this_FormalConstraint_0= ruleFormalConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintAccess().getFormalConstraintParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_FormalConstraint_0=ruleFormalConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FormalConstraint_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:2519:5: this_EnglishConstraint_1= ruleEnglishConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstraintAccess().getEnglishConstraintParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_EnglishConstraint_1=ruleEnglishConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EnglishConstraint_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleFormalConstraint"
    // InternalSpear.g:2535:1: entryRuleFormalConstraint returns [EObject current=null] : iv_ruleFormalConstraint= ruleFormalConstraint EOF ;
    public final EObject entryRuleFormalConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormalConstraint = null;


        try {
            // InternalSpear.g:2536:2: (iv_ruleFormalConstraint= ruleFormalConstraint EOF )
            // InternalSpear.g:2537:2: iv_ruleFormalConstraint= ruleFormalConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormalConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFormalConstraint=ruleFormalConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormalConstraint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormalConstraint"


    // $ANTLR start "ruleFormalConstraint"
    // InternalSpear.g:2544:1: ruleFormalConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) ( (lv_data_3_0= ruleData ) )* ) ;
    public final EObject ruleFormalConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;

        EObject lv_data_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2547:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) ( (lv_data_3_0= ruleData ) )* ) )
            // InternalSpear.g:2548:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) ( (lv_data_3_0= ruleData ) )* )
            {
            // InternalSpear.g:2548:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) ( (lv_data_3_0= ruleData ) )* )
            // InternalSpear.g:2548:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) ( (lv_data_3_0= ruleData ) )*
            {
            // InternalSpear.g:2548:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2549:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2549:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2550:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFormalConstraintAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFormalConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFormalConstraintAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:2570:1: ( (lv_expr_2_0= ruleExpr ) )
            // InternalSpear.g:2571:1: (lv_expr_2_0= ruleExpr )
            {
            // InternalSpear.g:2571:1: (lv_expr_2_0= ruleExpr )
            // InternalSpear.g:2572:3: lv_expr_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormalConstraintAccess().getExprExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_expr_2_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFormalConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpear.g:2588:2: ( (lv_data_3_0= ruleData ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=61 && LA62_0<=68)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalSpear.g:2589:1: (lv_data_3_0= ruleData )
            	    {
            	    // InternalSpear.g:2589:1: (lv_data_3_0= ruleData )
            	    // InternalSpear.g:2590:3: lv_data_3_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFormalConstraintAccess().getDataDataParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_3_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFormalConstraintRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_3_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormalConstraint"


    // $ANTLR start "entryRuleEnglishConstraint"
    // InternalSpear.g:2614:1: entryRuleEnglishConstraint returns [EObject current=null] : iv_ruleEnglishConstraint= ruleEnglishConstraint EOF ;
    public final EObject entryRuleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnglishConstraint = null;


        try {
            // InternalSpear.g:2615:2: (iv_ruleEnglishConstraint= ruleEnglishConstraint EOF )
            // InternalSpear.g:2616:2: iv_ruleEnglishConstraint= ruleEnglishConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnglishConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnglishConstraint=ruleEnglishConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnglishConstraint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnglishConstraint"


    // $ANTLR start "ruleEnglishConstraint"
    // InternalSpear.g:2623:1: ruleEnglishConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ( (lv_data_3_0= ruleData ) )* ) ;
    public final EObject ruleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_text_2_0=null;
        EObject lv_data_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2626:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ( (lv_data_3_0= ruleData ) )* ) )
            // InternalSpear.g:2627:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ( (lv_data_3_0= ruleData ) )* )
            {
            // InternalSpear.g:2627:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ( (lv_data_3_0= ruleData ) )* )
            // InternalSpear.g:2627:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ( (lv_data_3_0= ruleData ) )*
            {
            // InternalSpear.g:2627:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2628:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2628:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2629:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnglishConstraintAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnglishConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnglishConstraintAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:2649:1: ( (lv_text_2_0= RULE_STRING ) )
            // InternalSpear.g:2650:1: (lv_text_2_0= RULE_STRING )
            {
            // InternalSpear.g:2650:1: (lv_text_2_0= RULE_STRING )
            // InternalSpear.g:2651:3: lv_text_2_0= RULE_STRING
            {
            lv_text_2_0=(Token)match(input,RULE_STRING,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_text_2_0, grammarAccess.getEnglishConstraintAccess().getTextSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnglishConstraintRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"text",
                      		lv_text_2_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalSpear.g:2667:2: ( (lv_data_3_0= ruleData ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=61 && LA63_0<=68)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalSpear.g:2668:1: (lv_data_3_0= ruleData )
            	    {
            	    // InternalSpear.g:2668:1: (lv_data_3_0= ruleData )
            	    // InternalSpear.g:2669:3: lv_data_3_0= ruleData
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnglishConstraintAccess().getDataDataParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_data_3_0=ruleData();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnglishConstraintRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"data",
            	              		lv_data_3_0, 
            	              		"com.rockwellcollins.Spear.Data");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnglishConstraint"


    // $ANTLR start "entryRuleData"
    // InternalSpear.g:2693:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalSpear.g:2694:2: (iv_ruleData= ruleData EOF )
            // InternalSpear.g:2695:2: iv_ruleData= ruleData EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleData=ruleData();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleData; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalSpear.g:2702:1: ruleData returns [EObject current=null] : ( ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) ) | ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' ) | ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) ) | ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) ) | ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) ) | ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) ) | ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_string_3_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_ids_9_0=null;
        Token otherlv_10=null;
        Token lv_ids_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_string_16_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_string_20_0=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_string_24_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token lv_string_28_0=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token lv_string_32_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2705:28: ( ( ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) ) | ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' ) | ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) ) | ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) ) | ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) ) | ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) ) | ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) ) ) )
            // InternalSpear.g:2706:1: ( ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) ) | ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' ) | ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) ) | ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) ) | ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) ) | ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) ) | ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) ) )
            {
            // InternalSpear.g:2706:1: ( ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) ) | ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' ) | ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) ) | ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) ) | ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) ) | ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) ) | ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) ) )
            int alt66=7;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt66=1;
                }
                break;
            case 62:
            case 63:
                {
                alt66=2;
                }
                break;
            case 64:
                {
                alt66=3;
                }
                break;
            case 65:
                {
                alt66=4;
                }
                break;
            case 66:
                {
                alt66=5;
                }
                break;
            case 67:
                {
                alt66=6;
                }
                break;
            case 68:
                {
                alt66=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalSpear.g:2706:2: ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2706:2: ( () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) ) )
                    // InternalSpear.g:2706:3: () otherlv_1= 'text' otherlv_2= '=' ( (lv_string_3_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2706:3: ()
                    // InternalSpear.g:2707:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getDescriptionDataAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,61,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDataAccess().getTextKeyword_0_1());
                          
                    }
                    otherlv_2=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDataAccess().getEqualsSignKeyword_0_2());
                          
                    }
                    // InternalSpear.g:2720:1: ( (lv_string_3_0= RULE_STRING ) )
                    // InternalSpear.g:2721:1: (lv_string_3_0= RULE_STRING )
                    {
                    // InternalSpear.g:2721:1: (lv_string_3_0= RULE_STRING )
                    // InternalSpear.g:2722:3: lv_string_3_0= RULE_STRING
                    {
                    lv_string_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_3_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_0_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_3_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:2739:6: ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' )
                    {
                    // InternalSpear.g:2739:6: ( () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']' )
                    // InternalSpear.g:2739:7: () (otherlv_5= 'trace' | otherlv_6= 'parents' ) otherlv_7= '=' otherlv_8= '[' ( (lv_ids_9_0= RULE_ID ) ) (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )* otherlv_12= ']'
                    {
                    // InternalSpear.g:2739:7: ()
                    // InternalSpear.g:2740:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getTraceDataAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2745:2: (otherlv_5= 'trace' | otherlv_6= 'parents' )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==62) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==63) ) {
                        alt64=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalSpear.g:2745:4: otherlv_5= 'trace'
                            {
                            otherlv_5=(Token)match(input,62,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getDataAccess().getTraceKeyword_1_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:2750:7: otherlv_6= 'parents'
                            {
                            otherlv_6=(Token)match(input,63,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getDataAccess().getParentsKeyword_1_1_1());
                                  
                            }

                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,44,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDataAccess().getEqualsSignKeyword_1_2());
                          
                    }
                    otherlv_8=(Token)match(input,53,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDataAccess().getLeftSquareBracketKeyword_1_3());
                          
                    }
                    // InternalSpear.g:2762:1: ( (lv_ids_9_0= RULE_ID ) )
                    // InternalSpear.g:2763:1: (lv_ids_9_0= RULE_ID )
                    {
                    // InternalSpear.g:2763:1: (lv_ids_9_0= RULE_ID )
                    // InternalSpear.g:2764:3: lv_ids_9_0= RULE_ID
                    {
                    lv_ids_9_0=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_ids_9_0, grammarAccess.getDataAccess().getIdsIDTerminalRuleCall_1_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		addWithLastConsumed(
                             			current, 
                             			"ids",
                              		lv_ids_9_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:2780:2: (otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==37) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalSpear.g:2780:4: otherlv_10= ',' ( (lv_ids_11_0= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getDataAccess().getCommaKeyword_1_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:2784:1: ( (lv_ids_11_0= RULE_ID ) )
                    	    // InternalSpear.g:2785:1: (lv_ids_11_0= RULE_ID )
                    	    {
                    	    // InternalSpear.g:2785:1: (lv_ids_11_0= RULE_ID )
                    	    // InternalSpear.g:2786:3: lv_ids_11_0= RULE_ID
                    	    {
                    	    lv_ids_11_0=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_ids_11_0, grammarAccess.getDataAccess().getIdsIDTerminalRuleCall_1_5_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getDataRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"ids",
                    	              		lv_ids_11_0, 
                    	              		"org.eclipse.xtext.common.Terminals.ID");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getDataAccess().getRightSquareBracketKeyword_1_6());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:2807:6: ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2807:6: ( () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) ) )
                    // InternalSpear.g:2807:7: () otherlv_14= 'owner' otherlv_15= '=' ( (lv_string_16_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2807:7: ()
                    // InternalSpear.g:2808:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getOwnerDataAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_14=(Token)match(input,64,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getDataAccess().getOwnerKeyword_2_1());
                          
                    }
                    otherlv_15=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getDataAccess().getEqualsSignKeyword_2_2());
                          
                    }
                    // InternalSpear.g:2821:1: ( (lv_string_16_0= RULE_STRING ) )
                    // InternalSpear.g:2822:1: (lv_string_16_0= RULE_STRING )
                    {
                    // InternalSpear.g:2822:1: (lv_string_16_0= RULE_STRING )
                    // InternalSpear.g:2823:3: lv_string_16_0= RULE_STRING
                    {
                    lv_string_16_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_16_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_2_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_16_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:2840:6: ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2840:6: ( () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) ) )
                    // InternalSpear.g:2840:7: () otherlv_18= 'reviewDate' otherlv_19= '=' ( (lv_string_20_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2840:7: ()
                    // InternalSpear.g:2841:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getReviewDataAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_18=(Token)match(input,65,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getDataAccess().getReviewDateKeyword_3_1());
                          
                    }
                    otherlv_19=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getDataAccess().getEqualsSignKeyword_3_2());
                          
                    }
                    // InternalSpear.g:2854:1: ( (lv_string_20_0= RULE_STRING ) )
                    // InternalSpear.g:2855:1: (lv_string_20_0= RULE_STRING )
                    {
                    // InternalSpear.g:2855:1: (lv_string_20_0= RULE_STRING )
                    // InternalSpear.g:2856:3: lv_string_20_0= RULE_STRING
                    {
                    lv_string_20_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_20_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_3_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_20_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSpear.g:2873:6: ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2873:6: ( () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) ) )
                    // InternalSpear.g:2873:7: () otherlv_22= 'source' otherlv_23= '=' ( (lv_string_24_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2873:7: ()
                    // InternalSpear.g:2874:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getSourceDataAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_22=(Token)match(input,66,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getDataAccess().getSourceKeyword_4_1());
                          
                    }
                    otherlv_23=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getDataAccess().getEqualsSignKeyword_4_2());
                          
                    }
                    // InternalSpear.g:2887:1: ( (lv_string_24_0= RULE_STRING ) )
                    // InternalSpear.g:2888:1: (lv_string_24_0= RULE_STRING )
                    {
                    // InternalSpear.g:2888:1: (lv_string_24_0= RULE_STRING )
                    // InternalSpear.g:2889:3: lv_string_24_0= RULE_STRING
                    {
                    lv_string_24_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_24_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_4_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_24_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSpear.g:2906:6: ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2906:6: ( () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) ) )
                    // InternalSpear.g:2906:7: () otherlv_26= 'rationale' otherlv_27= '=' ( (lv_string_28_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2906:7: ()
                    // InternalSpear.g:2907:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getRationaleDataAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_26=(Token)match(input,67,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getDataAccess().getRationaleKeyword_5_1());
                          
                    }
                    otherlv_27=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getDataAccess().getEqualsSignKeyword_5_2());
                          
                    }
                    // InternalSpear.g:2920:1: ( (lv_string_28_0= RULE_STRING ) )
                    // InternalSpear.g:2921:1: (lv_string_28_0= RULE_STRING )
                    {
                    // InternalSpear.g:2921:1: (lv_string_28_0= RULE_STRING )
                    // InternalSpear.g:2922:3: lv_string_28_0= RULE_STRING
                    {
                    lv_string_28_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_28_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_5_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_28_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSpear.g:2939:6: ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) )
                    {
                    // InternalSpear.g:2939:6: ( () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) ) )
                    // InternalSpear.g:2939:7: () otherlv_30= 'comments' otherlv_31= '=' ( (lv_string_32_0= RULE_STRING ) )
                    {
                    // InternalSpear.g:2939:7: ()
                    // InternalSpear.g:2940:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDataAccess().getCommentsDataAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_30=(Token)match(input,68,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getDataAccess().getCommentsKeyword_6_1());
                          
                    }
                    otherlv_31=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getDataAccess().getEqualsSignKeyword_6_2());
                          
                    }
                    // InternalSpear.g:2953:1: ( (lv_string_32_0= RULE_STRING ) )
                    // InternalSpear.g:2954:1: (lv_string_32_0= RULE_STRING )
                    {
                    // InternalSpear.g:2954:1: (lv_string_32_0= RULE_STRING )
                    // InternalSpear.g:2955:3: lv_string_32_0= RULE_STRING
                    {
                    lv_string_32_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_32_0, grammarAccess.getDataAccess().getStringSTRINGTerminalRuleCall_6_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_32_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "entryRuleExpr"
    // InternalSpear.g:2979:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalSpear.g:2980:2: (iv_ruleExpr= ruleExpr EOF )
            // InternalSpear.g:2981:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // InternalSpear.g:2988:1: ruleExpr returns [EObject current=null] : this_WhileExpr_0= ruleWhileExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_WhileExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2991:28: (this_WhileExpr_0= ruleWhileExpr )
            // InternalSpear.g:2993:5: this_WhileExpr_0= ruleWhileExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getWhileExprParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_WhileExpr_0=ruleWhileExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_WhileExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleWhileExpr"
    // InternalSpear.g:3009:1: entryRuleWhileExpr returns [EObject current=null] : iv_ruleWhileExpr= ruleWhileExpr EOF ;
    public final EObject entryRuleWhileExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpr = null;


        try {
            // InternalSpear.g:3010:2: (iv_ruleWhileExpr= ruleWhileExpr EOF )
            // InternalSpear.g:3011:2: iv_ruleWhileExpr= ruleWhileExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhileExpr=ruleWhileExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileExpr"


    // $ANTLR start "ruleWhileExpr"
    // InternalSpear.g:3018:1: ruleWhileExpr returns [EObject current=null] : ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr ) ;
    public final EObject ruleWhileExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject this_ImpliesExpr_5 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3021:28: ( ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr ) )
            // InternalSpear.g:3022:1: ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr )
            {
            // InternalSpear.g:3022:1: ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==69) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID||LA67_0==RULE_INT||LA67_0==36||LA67_0==43||LA67_0==76||(LA67_0>=82 && LA67_0<=88)||LA67_0==100||LA67_0==102||LA67_0==106||LA67_0==112||(LA67_0>=114 && LA67_0<=120)) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalSpear.g:3022:2: ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:3022:2: ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) )
                    // InternalSpear.g:3022:3: () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) )
                    {
                    // InternalSpear.g:3022:3: ()
                    // InternalSpear.g:3023:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getWhileExprAccess().getWhileExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,69,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhileExprAccess().getWhileKeyword_0_1());
                          
                    }
                    // InternalSpear.g:3032:1: ( (lv_cond_2_0= ruleExpr ) )
                    // InternalSpear.g:3033:1: (lv_cond_2_0= ruleExpr )
                    {
                    // InternalSpear.g:3033:1: (lv_cond_2_0= ruleExpr )
                    // InternalSpear.g:3034:3: lv_cond_2_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWhileExprAccess().getCondExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_48);
                    lv_cond_2_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWhileExprRule());
                      	        }
                             		set(
                             			current, 
                             			"cond",
                              		lv_cond_2_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,70,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getWhileExprAccess().getThenKeyword_0_3());
                          
                    }
                    // InternalSpear.g:3054:1: ( (lv_then_4_0= ruleExpr ) )
                    // InternalSpear.g:3055:1: (lv_then_4_0= ruleExpr )
                    {
                    // InternalSpear.g:3055:1: (lv_then_4_0= ruleExpr )
                    // InternalSpear.g:3056:3: lv_then_4_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWhileExprAccess().getThenExprParserRuleCall_0_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_4_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWhileExprRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_4_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:3074:5: this_ImpliesExpr_5= ruleImpliesExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getWhileExprAccess().getImpliesExprParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_ImpliesExpr_5=ruleImpliesExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ImpliesExpr_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileExpr"


    // $ANTLR start "entryRuleImpliesExpr"
    // InternalSpear.g:3090:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalSpear.g:3091:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalSpear.g:3092:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImpliesExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImpliesExpr=ruleImpliesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImpliesExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesExpr"


    // $ANTLR start "ruleImpliesExpr"
    // InternalSpear.g:3099:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3102:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalSpear.g:3103:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalSpear.g:3103:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalSpear.g:3104:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_49);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3112:1: ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==71) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt69=1;
                }
            }
            else if ( (LA69_0==72) ) {
                int LA69_2 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // InternalSpear.g:3112:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalSpear.g:3112:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) )
                    // InternalSpear.g:3112:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    {
                    // InternalSpear.g:3125:6: ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    // InternalSpear.g:3125:7: () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    {
                    // InternalSpear.g:3125:7: ()
                    // InternalSpear.g:3126:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3131:2: ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    // InternalSpear.g:3132:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    {
                    // InternalSpear.g:3132:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    // InternalSpear.g:3133:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    {
                    // InternalSpear.g:3133:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==71) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==72) ) {
                        alt68=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalSpear.g:3134:3: lv_op_2_1= '=>'
                            {
                            lv_op_2_1=(Token)match(input,71,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getImpliesExprAccess().getOpEqualsSignGreaterThanSignKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getImpliesExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:3146:8: lv_op_2_2= 'implies'
                            {
                            lv_op_2_2=(Token)match(input,72,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getImpliesExprAccess().getOpImpliesKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getImpliesExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:3161:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalSpear.g:3162:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalSpear.g:3162:1: (lv_right_3_0= ruleImpliesExpr )
                    // InternalSpear.g:3163:3: lv_right_3_0= ruleImpliesExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImpliesExprAccess().getRightImpliesExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleImpliesExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImpliesExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.ImpliesExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesExpr"


    // $ANTLR start "entryRuleOrExpr"
    // InternalSpear.g:3187:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalSpear.g:3188:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalSpear.g:3189:2: iv_ruleOrExpr= ruleOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpr=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpr"


    // $ANTLR start "ruleOrExpr"
    // InternalSpear.g:3196:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3199:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? ) )
            // InternalSpear.g:3200:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? )
            {
            // InternalSpear.g:3200:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? )
            // InternalSpear.g:3201:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_50);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3209:1: ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==73) ) {
                int LA71_1 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt71=1;
                }
            }
            else if ( (LA71_0==74) ) {
                int LA71_2 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalSpear.g:3209:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) )
                    {
                    // InternalSpear.g:3209:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) )
                    // InternalSpear.g:3209:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    {
                    // InternalSpear.g:3222:6: ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    // InternalSpear.g:3222:7: () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    {
                    // InternalSpear.g:3222:7: ()
                    // InternalSpear.g:3223:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3228:2: ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    // InternalSpear.g:3229:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    {
                    // InternalSpear.g:3229:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    // InternalSpear.g:3230:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    {
                    // InternalSpear.g:3230:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==73) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==74) ) {
                        alt70=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalSpear.g:3231:3: lv_op_2_1= 'or'
                            {
                            lv_op_2_1=(Token)match(input,73,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getOrExprAccess().getOpOrKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOrExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:3243:8: lv_op_2_2= 'xor'
                            {
                            lv_op_2_2=(Token)match(input,74,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getOrExprAccess().getOpXorKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getOrExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:3258:4: ( (lv_right_3_0= ruleOrExpr ) )
                    // InternalSpear.g:3259:1: (lv_right_3_0= ruleOrExpr )
                    {
                    // InternalSpear.g:3259:1: (lv_right_3_0= ruleOrExpr )
                    // InternalSpear.g:3260:3: lv_right_3_0= ruleOrExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOrExprAccess().getRightOrExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleOrExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOrExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.OrExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpr"


    // $ANTLR start "entryRuleAndExpr"
    // InternalSpear.g:3284:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalSpear.g:3285:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalSpear.g:3286:2: iv_ruleAndExpr= ruleAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpr=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpr"


    // $ANTLR start "ruleAndExpr"
    // InternalSpear.g:3293:1: ruleAndExpr returns [EObject current=null] : (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AfterUntilExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3296:28: ( (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) )
            // InternalSpear.g:3297:1: (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            {
            // InternalSpear.g:3297:1: (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            // InternalSpear.g:3298:5: this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getAfterUntilExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_51);
            this_AfterUntilExpr_0=ruleAfterUntilExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AfterUntilExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3306:1: ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==75) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred5_InternalSpear()) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalSpear.g:3306:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) )
                    {
                    // InternalSpear.g:3306:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) )
                    // InternalSpear.g:3306:3: ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) )
                    {
                    // InternalSpear.g:3313:6: ( () ( (lv_op_2_0= 'and' ) ) )
                    // InternalSpear.g:3313:7: () ( (lv_op_2_0= 'and' ) )
                    {
                    // InternalSpear.g:3313:7: ()
                    // InternalSpear.g:3314:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3319:2: ( (lv_op_2_0= 'and' ) )
                    // InternalSpear.g:3320:1: (lv_op_2_0= 'and' )
                    {
                    // InternalSpear.g:3320:1: (lv_op_2_0= 'and' )
                    // InternalSpear.g:3321:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)match(input,75,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getAndExprAccess().getOpAndKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAndExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "and");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalSpear.g:3334:4: ( (lv_right_3_0= ruleAndExpr ) )
                    // InternalSpear.g:3335:1: (lv_right_3_0= ruleAndExpr )
                    {
                    // InternalSpear.g:3335:1: (lv_right_3_0= ruleAndExpr )
                    // InternalSpear.g:3336:3: lv_right_3_0= ruleAndExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAndExprAccess().getRightAndExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAndExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAndExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.AndExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpr"


    // $ANTLR start "entryRuleAfterUntilExpr"
    // InternalSpear.g:3360:1: entryRuleAfterUntilExpr returns [EObject current=null] : iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF ;
    public final EObject entryRuleAfterUntilExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfterUntilExpr = null;


        try {
            // InternalSpear.g:3361:2: (iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF )
            // InternalSpear.g:3362:2: iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAfterUntilExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAfterUntilExpr=ruleAfterUntilExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAfterUntilExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAfterUntilExpr"


    // $ANTLR start "ruleAfterUntilExpr"
    // InternalSpear.g:3369:1: ruleAfterUntilExpr returns [EObject current=null] : ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr ) ;
    public final EObject ruleAfterUntilExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_after_2_0 = null;

        EObject lv_until_4_0 = null;

        EObject this_TriggersExpr_5 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3372:28: ( ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr ) )
            // InternalSpear.g:3373:1: ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr )
            {
            // InternalSpear.g:3373:1: ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==76) ) {
                alt74=1;
            }
            else if ( (LA74_0==RULE_ID||LA74_0==RULE_INT||LA74_0==36||LA74_0==43||(LA74_0>=82 && LA74_0<=88)||LA74_0==100||LA74_0==102||LA74_0==106||LA74_0==112||(LA74_0>=114 && LA74_0<=120)) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalSpear.g:3373:2: ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? )
                    {
                    // InternalSpear.g:3373:2: ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? )
                    // InternalSpear.g:3373:3: () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )?
                    {
                    // InternalSpear.g:3373:3: ()
                    // InternalSpear.g:3374:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAfterUntilExprAccess().getAfterUntilExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,76,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAfterUntilExprAccess().getAfterKeyword_0_1());
                          
                    }
                    // InternalSpear.g:3383:1: ( (lv_after_2_0= ruleTriggersExpr ) )
                    // InternalSpear.g:3384:1: (lv_after_2_0= ruleTriggersExpr )
                    {
                    // InternalSpear.g:3384:1: (lv_after_2_0= ruleTriggersExpr )
                    // InternalSpear.g:3385:3: lv_after_2_0= ruleTriggersExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAfterUntilExprAccess().getAfterTriggersExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_52);
                    lv_after_2_0=ruleTriggersExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAfterUntilExprRule());
                      	        }
                             		set(
                             			current, 
                             			"after",
                              		lv_after_2_0, 
                              		"com.rockwellcollins.Spear.TriggersExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:3401:2: ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==77) ) {
                        int LA73_1 = input.LA(2);

                        if ( (synpred6_InternalSpear()) ) {
                            alt73=1;
                        }
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalSpear.g:3401:3: ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) )
                            {
                            // InternalSpear.g:3401:3: ( ( 'until' )=>otherlv_3= 'until' )
                            // InternalSpear.g:3401:4: ( 'until' )=>otherlv_3= 'until'
                            {
                            otherlv_3=(Token)match(input,77,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getAfterUntilExprAccess().getUntilKeyword_0_3_0());
                                  
                            }

                            }

                            // InternalSpear.g:3406:2: ( (lv_until_4_0= ruleTriggersExpr ) )
                            // InternalSpear.g:3407:1: (lv_until_4_0= ruleTriggersExpr )
                            {
                            // InternalSpear.g:3407:1: (lv_until_4_0= ruleTriggersExpr )
                            // InternalSpear.g:3408:3: lv_until_4_0= ruleTriggersExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAfterUntilExprAccess().getUntilTriggersExprParserRuleCall_0_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_until_4_0=ruleTriggersExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAfterUntilExprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"until",
                                      		lv_until_4_0, 
                                      		"com.rockwellcollins.Spear.TriggersExpr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:3426:5: this_TriggersExpr_5= ruleTriggersExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAfterUntilExprAccess().getTriggersExprParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_TriggersExpr_5=ruleTriggersExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TriggersExpr_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAfterUntilExpr"


    // $ANTLR start "entryRuleTriggersExpr"
    // InternalSpear.g:3442:1: entryRuleTriggersExpr returns [EObject current=null] : iv_ruleTriggersExpr= ruleTriggersExpr EOF ;
    public final EObject entryRuleTriggersExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggersExpr = null;


        try {
            // InternalSpear.g:3443:2: (iv_ruleTriggersExpr= ruleTriggersExpr EOF )
            // InternalSpear.g:3444:2: iv_ruleTriggersExpr= ruleTriggersExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggersExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTriggersExpr=ruleTriggersExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggersExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggersExpr"


    // $ANTLR start "ruleTriggersExpr"
    // InternalSpear.g:3451:1: ruleTriggersExpr returns [EObject current=null] : (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) ;
    public final EObject ruleTriggersExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_SinceExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3454:28: ( (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) )
            // InternalSpear.g:3455:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            {
            // InternalSpear.g:3455:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            // InternalSpear.g:3456:5: this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTriggersExprAccess().getSinceExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_53);
            this_SinceExpr_0=ruleSinceExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SinceExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3464:1: ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==78) ) {
                int LA76_1 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt76=1;
                }
            }
            else if ( (LA76_0==79) ) {
                int LA76_2 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // InternalSpear.g:3464:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) )
                    {
                    // InternalSpear.g:3464:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) )
                    // InternalSpear.g:3464:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    {
                    // InternalSpear.g:3477:6: ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    // InternalSpear.g:3477:7: () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    {
                    // InternalSpear.g:3477:7: ()
                    // InternalSpear.g:3478:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getTriggersExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3483:2: ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    // InternalSpear.g:3484:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    {
                    // InternalSpear.g:3484:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    // InternalSpear.g:3485:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    {
                    // InternalSpear.g:3485:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==78) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==79) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalSpear.g:3486:3: lv_op_2_1= 'T'
                            {
                            lv_op_2_1=(Token)match(input,78,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getTriggersExprAccess().getOpTKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTriggersExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:3498:8: lv_op_2_2= 'triggers'
                            {
                            lv_op_2_2=(Token)match(input,79,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getTriggersExprAccess().getOpTriggersKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTriggersExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:3513:4: ( (lv_right_3_0= ruleTriggersExpr ) )
                    // InternalSpear.g:3514:1: (lv_right_3_0= ruleTriggersExpr )
                    {
                    // InternalSpear.g:3514:1: (lv_right_3_0= ruleTriggersExpr )
                    // InternalSpear.g:3515:3: lv_right_3_0= ruleTriggersExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTriggersExprAccess().getRightTriggersExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleTriggersExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTriggersExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.TriggersExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggersExpr"


    // $ANTLR start "entryRuleSinceExpr"
    // InternalSpear.g:3539:1: entryRuleSinceExpr returns [EObject current=null] : iv_ruleSinceExpr= ruleSinceExpr EOF ;
    public final EObject entryRuleSinceExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSinceExpr = null;


        try {
            // InternalSpear.g:3540:2: (iv_ruleSinceExpr= ruleSinceExpr EOF )
            // InternalSpear.g:3541:2: iv_ruleSinceExpr= ruleSinceExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSinceExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSinceExpr=ruleSinceExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSinceExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSinceExpr"


    // $ANTLR start "ruleSinceExpr"
    // InternalSpear.g:3548:1: ruleSinceExpr returns [EObject current=null] : (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) ;
    public final EObject ruleSinceExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TemporalPrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3551:28: ( (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) )
            // InternalSpear.g:3552:1: (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            {
            // InternalSpear.g:3552:1: (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            // InternalSpear.g:3553:5: this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSinceExprAccess().getTemporalPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_54);
            this_TemporalPrefixExpr_0=ruleTemporalPrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TemporalPrefixExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3561:1: ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==80) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred8_InternalSpear()) ) {
                    alt78=1;
                }
            }
            else if ( (LA78_0==81) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred8_InternalSpear()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalSpear.g:3561:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) )
                    {
                    // InternalSpear.g:3561:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) )
                    // InternalSpear.g:3561:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    {
                    // InternalSpear.g:3574:6: ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    // InternalSpear.g:3574:7: () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    {
                    // InternalSpear.g:3574:7: ()
                    // InternalSpear.g:3575:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getSinceExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3580:2: ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    // InternalSpear.g:3581:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    {
                    // InternalSpear.g:3581:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    // InternalSpear.g:3582:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    {
                    // InternalSpear.g:3582:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==80) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==81) ) {
                        alt77=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalSpear.g:3583:3: lv_op_2_1= 'S'
                            {
                            lv_op_2_1=(Token)match(input,80,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getSinceExprAccess().getOpSKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSinceExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:3595:8: lv_op_2_2= 'since'
                            {
                            lv_op_2_2=(Token)match(input,81,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getSinceExprAccess().getOpSinceKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSinceExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:3610:4: ( (lv_right_3_0= ruleSinceExpr ) )
                    // InternalSpear.g:3611:1: (lv_right_3_0= ruleSinceExpr )
                    {
                    // InternalSpear.g:3611:1: (lv_right_3_0= ruleSinceExpr )
                    // InternalSpear.g:3612:3: lv_right_3_0= ruleSinceExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSinceExprAccess().getRightSinceExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleSinceExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSinceExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.SinceExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSinceExpr"


    // $ANTLR start "entryRuleTemporalPrefixExpr"
    // InternalSpear.g:3636:1: entryRuleTemporalPrefixExpr returns [EObject current=null] : iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF ;
    public final EObject entryRuleTemporalPrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalPrefixExpr = null;


        try {
            // InternalSpear.g:3637:2: (iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF )
            // InternalSpear.g:3638:2: iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemporalPrefixExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTemporalPrefixExpr=ruleTemporalPrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemporalPrefixExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemporalPrefixExpr"


    // $ANTLR start "ruleTemporalPrefixExpr"
    // InternalSpear.g:3645:1: ruleTemporalPrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr ) ;
    public final EObject ruleTemporalPrefixExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        Token lv_op_1_7=null;
        EObject lv_expr_2_0 = null;

        EObject this_RelationalExpr_3 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3648:28: ( ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr ) )
            // InternalSpear.g:3649:1: ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr )
            {
            // InternalSpear.g:3649:1: ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=82 && LA80_0<=88)) ) {
                alt80=1;
            }
            else if ( (LA80_0==RULE_ID||LA80_0==RULE_INT||LA80_0==36||LA80_0==43||LA80_0==100||LA80_0==102||LA80_0==106||LA80_0==112||(LA80_0>=114 && LA80_0<=120)) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalSpear.g:3649:2: ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) )
                    {
                    // InternalSpear.g:3649:2: ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) )
                    // InternalSpear.g:3649:3: () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) )
                    {
                    // InternalSpear.g:3649:3: ()
                    // InternalSpear.g:3650:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTemporalPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3655:2: ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) )
                    // InternalSpear.g:3656:1: ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) )
                    {
                    // InternalSpear.g:3656:1: ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) )
                    // InternalSpear.g:3657:1: (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' )
                    {
                    // InternalSpear.g:3657:1: (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' )
                    int alt79=7;
                    switch ( input.LA(1) ) {
                    case 82:
                        {
                        alt79=1;
                        }
                        break;
                    case 83:
                        {
                        alt79=2;
                        }
                        break;
                    case 84:
                        {
                        alt79=3;
                        }
                        break;
                    case 85:
                        {
                        alt79=4;
                        }
                        break;
                    case 86:
                        {
                        alt79=5;
                        }
                        break;
                    case 87:
                        {
                        alt79=6;
                        }
                        break;
                    case 88:
                        {
                        alt79=7;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 0, input);

                        throw nvae;
                    }

                    switch (alt79) {
                        case 1 :
                            // InternalSpear.g:3658:3: lv_op_1_1= 'O'
                            {
                            lv_op_1_1=(Token)match(input,82,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_1, grammarAccess.getTemporalPrefixExprAccess().getOpOKeyword_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:3670:8: lv_op_1_2= 'once'
                            {
                            lv_op_1_2=(Token)match(input,83,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_2, grammarAccess.getTemporalPrefixExprAccess().getOpOnceKeyword_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_2, null);
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // InternalSpear.g:3682:8: lv_op_1_3= 'H'
                            {
                            lv_op_1_3=(Token)match(input,84,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_3, grammarAccess.getTemporalPrefixExprAccess().getOpHKeyword_0_1_0_2());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_3, null);
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // InternalSpear.g:3694:8: lv_op_1_4= 'historically'
                            {
                            lv_op_1_4=(Token)match(input,85,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_4, grammarAccess.getTemporalPrefixExprAccess().getOpHistoricallyKeyword_0_1_0_3());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_4, null);
                              	    
                            }

                            }
                            break;
                        case 5 :
                            // InternalSpear.g:3706:8: lv_op_1_5= 'never'
                            {
                            lv_op_1_5=(Token)match(input,86,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_5, grammarAccess.getTemporalPrefixExprAccess().getOpNeverKeyword_0_1_0_4());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_5, null);
                              	    
                            }

                            }
                            break;
                        case 6 :
                            // InternalSpear.g:3718:8: lv_op_1_6= 'before'
                            {
                            lv_op_1_6=(Token)match(input,87,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_6, grammarAccess.getTemporalPrefixExprAccess().getOpBeforeKeyword_0_1_0_5());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_6, null);
                              	    
                            }

                            }
                            break;
                        case 7 :
                            // InternalSpear.g:3730:8: lv_op_1_7= 'initially'
                            {
                            lv_op_1_7=(Token)match(input,88,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_7, grammarAccess.getTemporalPrefixExprAccess().getOpInitiallyKeyword_0_1_0_6());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTemporalPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_7, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpear.g:3745:2: ( (lv_expr_2_0= ruleTemporalPrefixExpr ) )
                    // InternalSpear.g:3746:1: (lv_expr_2_0= ruleTemporalPrefixExpr )
                    {
                    // InternalSpear.g:3746:1: (lv_expr_2_0= ruleTemporalPrefixExpr )
                    // InternalSpear.g:3747:3: lv_expr_2_0= ruleTemporalPrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTemporalPrefixExprAccess().getExprTemporalPrefixExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=ruleTemporalPrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTemporalPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"com.rockwellcollins.Spear.TemporalPrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:3765:5: this_RelationalExpr_3= ruleRelationalExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTemporalPrefixExprAccess().getRelationalExprParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RelationalExpr_3=ruleRelationalExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RelationalExpr_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalPrefixExpr"


    // $ANTLR start "entryRuleRelationalExpr"
    // InternalSpear.g:3781:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalSpear.g:3782:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalSpear.g:3783:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpr=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpr"


    // $ANTLR start "ruleRelationalExpr"
    // InternalSpear.g:3790:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3793:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) )
            // InternalSpear.g:3794:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            {
            // InternalSpear.g:3794:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            // InternalSpear.g:3795:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExprAccess().getPlusExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_55);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PlusExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3803:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalSpear.g:3803:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) )
                    {
                    // InternalSpear.g:3803:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalSpear.g:3803:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalSpear.g:3808:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalSpear.g:3808:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalSpear.g:3808:7: ()
                    // InternalSpear.g:3809:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3814:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalSpear.g:3815:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalSpear.g:3815:1: (lv_op_2_0= ruleRelationalOp )
                    // InternalSpear.g:3816:3: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_32);
                    lv_op_2_0=ruleRelationalOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_2_0, 
                              		"com.rockwellcollins.Spear.RelationalOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalSpear.g:3832:4: ( (lv_right_3_0= ruleRelationalExpr ) )
                    // InternalSpear.g:3833:1: (lv_right_3_0= ruleRelationalExpr )
                    {
                    // InternalSpear.g:3833:1: (lv_right_3_0= ruleRelationalExpr )
                    // InternalSpear.g:3834:3: lv_right_3_0= ruleRelationalExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getRightRelationalExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleRelationalExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.RelationalExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpr"


    // $ANTLR start "entryRuleRelationalOp"
    // InternalSpear.g:3858:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalSpear.g:3859:2: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalSpear.g:3860:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOp.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOp"


    // $ANTLR start "ruleRelationalOp"
    // InternalSpear.g:3867:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:3870:28: ( (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) ) )
            // InternalSpear.g:3871:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )
            {
            // InternalSpear.g:3871:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )
            int alt82=12;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalSpear.g:3872:2: kw= '<'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:3878:6: (kw= 'less' kw= 'than' )
                    {
                    // InternalSpear.g:3878:6: (kw= 'less' kw= 'than' )
                    // InternalSpear.g:3879:2: kw= 'less' kw= 'than'
                    {
                    kw=(Token)match(input,90,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:3892:2: kw= '<='
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:3898:6: (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3898:6: (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3899:2: kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,90,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessKeyword_3_0()); 
                          
                    }
                    kw=(Token)match(input,91,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_3_1()); 
                          
                    }
                    kw=(Token)match(input,73,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getOrKeyword_3_2()); 
                          
                    }
                    kw=(Token)match(input,93,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_3_3()); 
                          
                    }
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_3_4()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSpear.g:3930:2: kw= '>'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpear.g:3936:6: (kw= 'greater' kw= 'than' )
                    {
                    // InternalSpear.g:3936:6: (kw= 'greater' kw= 'than' )
                    // InternalSpear.g:3937:2: kw= 'greater' kw= 'than'
                    {
                    kw=(Token)match(input,96,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterKeyword_5_0()); 
                          
                    }
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_5_1()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSpear.g:3950:2: kw= '>='
                    {
                    kw=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalSpear.g:3956:6: (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3956:6: (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3957:2: kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,96,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterKeyword_7_0()); 
                          
                    }
                    kw=(Token)match(input,91,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_7_1()); 
                          
                    }
                    kw=(Token)match(input,73,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getOrKeyword_7_2()); 
                          
                    }
                    kw=(Token)match(input,93,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_7_3()); 
                          
                    }
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_7_4()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSpear.g:3988:2: kw= '=='
                    {
                    kw=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalSpear.g:3994:6: (kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3994:6: (kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3995:2: kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,93,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_9_0()); 
                          
                    }
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_9_1()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalSpear.g:4008:2: kw= '<>'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignGreaterThanSignKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalSpear.g:4014:6: (kw= 'not' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:4014:6: (kw= 'not' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:4015:2: kw= 'not' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,100,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getNotKeyword_11_0()); 
                          
                    }
                    kw=(Token)match(input,93,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_11_1()); 
                          
                    }
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_11_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOp"


    // $ANTLR start "entryRulePlusExpr"
    // InternalSpear.g:4040:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalSpear.g:4041:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalSpear.g:4042:2: iv_rulePlusExpr= rulePlusExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePlusExpr=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusExpr"


    // $ANTLR start "rulePlusExpr"
    // InternalSpear.g:4049:1: rulePlusExpr returns [EObject current=null] : (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplyExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4052:28: ( (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalSpear.g:4053:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalSpear.g:4053:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalSpear.g:4054:5: this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPlusExprAccess().getMultiplyExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_60);
            this_MultiplyExpr_0=ruleMultiplyExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplyExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:4062:1: ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==101) ) {
                int LA84_1 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt84=1;
                }
            }
            else if ( (LA84_0==102) ) {
                int LA84_2 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt84=1;
                }
            }
            switch (alt84) {
                case 1 :
                    // InternalSpear.g:4062:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalSpear.g:4062:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) )
                    // InternalSpear.g:4062:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    {
                    // InternalSpear.g:4075:6: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    // InternalSpear.g:4075:7: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    {
                    // InternalSpear.g:4075:7: ()
                    // InternalSpear.g:4076:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4081:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalSpear.g:4082:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalSpear.g:4082:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalSpear.g:4083:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalSpear.g:4083:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==101) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==102) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalSpear.g:4084:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,101,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getPlusExprAccess().getOpPlusSignKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPlusExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:4096:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,102,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getPlusExprAccess().getOpHyphenMinusKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPlusExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:4111:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalSpear.g:4112:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalSpear.g:4112:1: (lv_right_3_0= rulePlusExpr )
                    // InternalSpear.g:4113:3: lv_right_3_0= rulePlusExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPlusExprAccess().getRightPlusExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=rulePlusExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPlusExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.PlusExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusExpr"


    // $ANTLR start "entryRuleMultiplyExpr"
    // InternalSpear.g:4137:1: entryRuleMultiplyExpr returns [EObject current=null] : iv_ruleMultiplyExpr= ruleMultiplyExpr EOF ;
    public final EObject entryRuleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyExpr = null;


        try {
            // InternalSpear.g:4138:2: (iv_ruleMultiplyExpr= ruleMultiplyExpr EOF )
            // InternalSpear.g:4139:2: iv_ruleMultiplyExpr= ruleMultiplyExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplyExpr=ruleMultiplyExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplyExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplyExpr"


    // $ANTLR start "ruleMultiplyExpr"
    // InternalSpear.g:4146:1: ruleMultiplyExpr returns [EObject current=null] : (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) ;
    public final EObject ruleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ArrowExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4149:28: ( (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) )
            // InternalSpear.g:4150:1: (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            {
            // InternalSpear.g:4150:1: (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            // InternalSpear.g:4151:5: this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplyExprAccess().getArrowExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_61);
            this_ArrowExpr_0=ruleArrowExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ArrowExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:4159:1: ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            int alt86=2;
            switch ( input.LA(1) ) {
                case 47:
                    {
                    int LA86_1 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt86=1;
                    }
                    }
                    break;
                case 48:
                    {
                    int LA86_2 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt86=1;
                    }
                    }
                    break;
                case 103:
                    {
                    int LA86_3 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt86=1;
                    }
                    }
                    break;
            }

            switch (alt86) {
                case 1 :
                    // InternalSpear.g:4159:2: ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) )
                    {
                    // InternalSpear.g:4159:2: ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) )
                    // InternalSpear.g:4159:3: ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) )
                    {
                    // InternalSpear.g:4175:6: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) )
                    // InternalSpear.g:4175:7: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) )
                    {
                    // InternalSpear.g:4175:7: ()
                    // InternalSpear.g:4176:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getMultiplyExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4181:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) )
                    // InternalSpear.g:4182:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) )
                    {
                    // InternalSpear.g:4182:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) )
                    // InternalSpear.g:4183:1: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' )
                    {
                    // InternalSpear.g:4183:1: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' )
                    int alt85=3;
                    switch ( input.LA(1) ) {
                    case 47:
                        {
                        alt85=1;
                        }
                        break;
                    case 48:
                        {
                        alt85=2;
                        }
                        break;
                    case 103:
                        {
                        alt85=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }

                    switch (alt85) {
                        case 1 :
                            // InternalSpear.g:4184:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,47,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getMultiplyExprAccess().getOpAsteriskKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMultiplyExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:4196:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,48,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getMultiplyExprAccess().getOpSolidusKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMultiplyExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // InternalSpear.g:4208:8: lv_op_2_3= 'mod'
                            {
                            lv_op_2_3=(Token)match(input,103,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_3, grammarAccess.getMultiplyExprAccess().getOpModKeyword_1_0_0_1_0_2());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMultiplyExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_3, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:4223:4: ( (lv_right_3_0= ruleMultiplyExpr ) )
                    // InternalSpear.g:4224:1: (lv_right_3_0= ruleMultiplyExpr )
                    {
                    // InternalSpear.g:4224:1: (lv_right_3_0= ruleMultiplyExpr )
                    // InternalSpear.g:4225:3: lv_right_3_0= ruleMultiplyExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplyExprAccess().getRightMultiplyExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleMultiplyExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplyExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.MultiplyExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplyExpr"


    // $ANTLR start "entryRuleArrowExpr"
    // InternalSpear.g:4249:1: entryRuleArrowExpr returns [EObject current=null] : iv_ruleArrowExpr= ruleArrowExpr EOF ;
    public final EObject entryRuleArrowExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrowExpr = null;


        try {
            // InternalSpear.g:4250:2: (iv_ruleArrowExpr= ruleArrowExpr EOF )
            // InternalSpear.g:4251:2: iv_ruleArrowExpr= ruleArrowExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrowExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrowExpr=ruleArrowExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrowExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrowExpr"


    // $ANTLR start "ruleArrowExpr"
    // InternalSpear.g:4258:1: ruleArrowExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? ) ;
    public final EObject ruleArrowExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4261:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? ) )
            // InternalSpear.g:4262:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? )
            {
            // InternalSpear.g:4262:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? )
            // InternalSpear.g:4263:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getArrowExprAccess().getPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_62);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrefixExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:4271:1: ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==104) ) {
                int LA88_1 = input.LA(2);

                if ( (synpred12_InternalSpear()) ) {
                    alt88=1;
                }
            }
            else if ( (LA88_0==105) ) {
                int LA88_2 = input.LA(2);

                if ( (synpred12_InternalSpear()) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // InternalSpear.g:4271:2: ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) )
                    {
                    // InternalSpear.g:4271:2: ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) )
                    // InternalSpear.g:4271:3: ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) )
                    {
                    // InternalSpear.g:4284:6: ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) )
                    // InternalSpear.g:4284:7: () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) )
                    {
                    // InternalSpear.g:4284:7: ()
                    // InternalSpear.g:4285:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getArrowExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4290:2: ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) )
                    // InternalSpear.g:4291:1: ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) )
                    {
                    // InternalSpear.g:4291:1: ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) )
                    // InternalSpear.g:4292:1: (lv_op_2_1= '->' | lv_op_2_2= 'arrow' )
                    {
                    // InternalSpear.g:4292:1: (lv_op_2_1= '->' | lv_op_2_2= 'arrow' )
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==104) ) {
                        alt87=1;
                    }
                    else if ( (LA87_0==105) ) {
                        alt87=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 87, 0, input);

                        throw nvae;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalSpear.g:4293:3: lv_op_2_1= '->'
                            {
                            lv_op_2_1=(Token)match(input,104,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_1, grammarAccess.getArrowExprAccess().getOpHyphenMinusGreaterThanSignKeyword_1_0_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getArrowExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:4305:8: lv_op_2_2= 'arrow'
                            {
                            lv_op_2_2=(Token)match(input,105,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_2, grammarAccess.getArrowExprAccess().getOpArrowKeyword_1_0_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getArrowExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }

                    // InternalSpear.g:4320:4: ( (lv_right_3_0= ruleArrowExpr ) )
                    // InternalSpear.g:4321:1: (lv_right_3_0= ruleArrowExpr )
                    {
                    // InternalSpear.g:4321:1: (lv_right_3_0= ruleArrowExpr )
                    // InternalSpear.g:4322:3: lv_right_3_0= ruleArrowExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrowExprAccess().getRightArrowExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleArrowExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArrowExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.Spear.ArrowExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrowExpr"


    // $ANTLR start "entryRulePrefixExpr"
    // InternalSpear.g:4346:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalSpear.g:4347:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalSpear.g:4348:2: iv_rulePrefixExpr= rulePrefixExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixExpr=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixExpr"


    // $ANTLR start "rulePrefixExpr"
    // InternalSpear.g:4355:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr ) ;
    public final EObject rulePrefixExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_expr_2_0 = null;

        EObject lv_var_5_0 = null;

        EObject lv_init_9_0 = null;

        EObject this_AccessExpr_10 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4358:28: ( ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr ) )
            // InternalSpear.g:4359:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr )
            {
            // InternalSpear.g:4359:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr )
            int alt91=3;
            switch ( input.LA(1) ) {
            case 100:
            case 102:
                {
                alt91=1;
                }
                break;
            case 106:
                {
                alt91=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case 36:
            case 43:
            case 112:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                {
                alt91=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalSpear.g:4359:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalSpear.g:4359:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalSpear.g:4359:3: () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalSpear.g:4359:3: ()
                    // InternalSpear.g:4360:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4365:2: ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) )
                    // InternalSpear.g:4366:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) )
                    {
                    // InternalSpear.g:4366:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) )
                    // InternalSpear.g:4367:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' )
                    {
                    // InternalSpear.g:4367:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' )
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==102) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==100) ) {
                        alt89=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 0, input);

                        throw nvae;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalSpear.g:4368:3: lv_op_1_1= '-'
                            {
                            lv_op_1_1=(Token)match(input,102,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_1, grammarAccess.getPrefixExprAccess().getOpHyphenMinusKeyword_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalSpear.g:4380:8: lv_op_1_2= 'not'
                            {
                            lv_op_1_2=(Token)match(input,100,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_2, grammarAccess.getPrefixExprAccess().getOpNotKeyword_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalSpear.g:4395:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalSpear.g:4396:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalSpear.g:4396:1: (lv_expr_2_0= rulePrefixExpr )
                    // InternalSpear.g:4397:3: lv_expr_2_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getExprPrefixExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"com.rockwellcollins.Spear.PrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:4414:6: ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? )
                    {
                    // InternalSpear.g:4414:6: ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? )
                    // InternalSpear.g:4414:7: () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )?
                    {
                    // InternalSpear.g:4414:7: ()
                    // InternalSpear.g:4415:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getPreviousExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,106,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrefixExprAccess().getPreviousKeyword_1_1());
                          
                    }
                    // InternalSpear.g:4424:1: ( (lv_var_5_0= rulePrefixExpr ) )
                    // InternalSpear.g:4425:1: (lv_var_5_0= rulePrefixExpr )
                    {
                    // InternalSpear.g:4425:1: (lv_var_5_0= rulePrefixExpr )
                    // InternalSpear.g:4426:3: lv_var_5_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getVarPrefixExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_63);
                    lv_var_5_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_5_0, 
                              		"com.rockwellcollins.Spear.PrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:4442:2: ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==107) ) {
                        int LA90_1 = input.LA(2);

                        if ( (synpred13_InternalSpear()) ) {
                            alt90=1;
                        }
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalSpear.g:4442:3: ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) )
                            {
                            // InternalSpear.g:4442:3: ( ( 'with' )=>otherlv_6= 'with' )
                            // InternalSpear.g:4442:4: ( 'with' )=>otherlv_6= 'with'
                            {
                            otherlv_6=(Token)match(input,107,FOLLOW_64); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getPrefixExprAccess().getWithKeyword_1_3_0());
                                  
                            }

                            }

                            otherlv_7=(Token)match(input,108,FOLLOW_65); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getPrefixExprAccess().getInitialKeyword_1_3_1());
                                  
                            }
                            otherlv_8=(Token)match(input,109,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getPrefixExprAccess().getValueKeyword_1_3_2());
                                  
                            }
                            // InternalSpear.g:4455:1: ( (lv_init_9_0= rulePrefixExpr ) )
                            // InternalSpear.g:4456:1: (lv_init_9_0= rulePrefixExpr )
                            {
                            // InternalSpear.g:4456:1: (lv_init_9_0= rulePrefixExpr )
                            // InternalSpear.g:4457:3: lv_init_9_0= rulePrefixExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPrefixExprAccess().getInitPrefixExprParserRuleCall_1_3_3_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_init_9_0=rulePrefixExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"init",
                                      		lv_init_9_0, 
                                      		"com.rockwellcollins.Spear.PrefixExpr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:4475:5: this_AccessExpr_10= ruleAccessExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixExprAccess().getAccessExprParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_AccessExpr_10=ruleAccessExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AccessExpr_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixExpr"


    // $ANTLR start "entryRuleAccessExpr"
    // InternalSpear.g:4491:1: entryRuleAccessExpr returns [EObject current=null] : iv_ruleAccessExpr= ruleAccessExpr EOF ;
    public final EObject entryRuleAccessExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessExpr = null;


        try {
            // InternalSpear.g:4492:2: (iv_ruleAccessExpr= ruleAccessExpr EOF )
            // InternalSpear.g:4493:2: iv_ruleAccessExpr= ruleAccessExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccessExpr=ruleAccessExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessExpr"


    // $ANTLR start "ruleAccessExpr"
    // InternalSpear.g:4500:1: ruleAccessExpr returns [EObject current=null] : (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) ;
    public final EObject ruleAccessExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject this_AtomicExpr_0 = null;

        EObject lv_value_8_0 = null;

        EObject lv_index_12_0 = null;

        EObject lv_value_15_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4503:28: ( (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) )
            // InternalSpear.g:4504:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            {
            // InternalSpear.g:4504:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            // InternalSpear.g:4505:5: this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAccessExprAccess().getAtomicExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_66);
            this_AtomicExpr_0=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:4513:1: ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            loop93:
            do {
                int alt93=4;
                switch ( input.LA(1) ) {
                case 110:
                    {
                    int LA93_2 = input.LA(2);

                    if ( (synpred14_InternalSpear()) ) {
                        alt93=1;
                    }


                    }
                    break;
                case 51:
                    {
                    int LA93_3 = input.LA(2);

                    if ( (synpred15_InternalSpear()) ) {
                        alt93=2;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA93_4 = input.LA(2);

                    if ( (synpred16_InternalSpear()) ) {
                        alt93=3;
                    }


                    }
                    break;

                }

                switch (alt93) {
            	case 1 :
            	    // InternalSpear.g:4513:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    {
            	    // InternalSpear.g:4513:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    // InternalSpear.g:4513:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalSpear.g:4513:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) )
            	    // InternalSpear.g:4513:4: ( ( () '.' ) )=> ( () otherlv_2= '.' )
            	    {
            	    // InternalSpear.g:4515:5: ( () otherlv_2= '.' )
            	    // InternalSpear.g:4515:6: () otherlv_2= '.'
            	    {
            	    // InternalSpear.g:4515:6: ()
            	    // InternalSpear.g:4516:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordAccessExprRecordAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,110,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAccessExprAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4525:3: ( (otherlv_3= RULE_ID ) )
            	    // InternalSpear.g:4526:1: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSpear.g:4526:1: (otherlv_3= RULE_ID )
            	    // InternalSpear.g:4527:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_66); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getAccessExprAccess().getFieldFieldTypeCrossReference_1_0_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpear.g:4539:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    {
            	    // InternalSpear.g:4539:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    // InternalSpear.g:4539:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}'
            	    {
            	    // InternalSpear.g:4539:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) )
            	    // InternalSpear.g:4539:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    {
            	    // InternalSpear.g:4547:5: ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    // InternalSpear.g:4547:6: () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':='
            	    {
            	    // InternalSpear.g:4547:6: ()
            	    // InternalSpear.g:4548:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordUpdateExprRecordAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_5=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAccessExprAccess().getLeftCurlyBracketKeyword_1_1_0_0_1());
            	          
            	    }
            	    // InternalSpear.g:4557:1: ( (otherlv_6= RULE_ID ) )
            	    // InternalSpear.g:4558:1: (otherlv_6= RULE_ID )
            	    {
            	    // InternalSpear.g:4558:1: (otherlv_6= RULE_ID )
            	    // InternalSpear.g:4559:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_67); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getAccessExprAccess().getFieldFieldTypeCrossReference_1_1_0_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    otherlv_7=(Token)match(input,111,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_1_0_0_3());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4574:3: ( (lv_value_8_0= ruleExpr ) )
            	    // InternalSpear.g:4575:1: (lv_value_8_0= ruleExpr )
            	    {
            	    // InternalSpear.g:4575:1: (lv_value_8_0= ruleExpr )
            	    // InternalSpear.g:4576:3: lv_value_8_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_68);
            	    lv_value_8_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"value",
            	              		lv_value_8_0, 
            	              		"com.rockwellcollins.Spear.Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,52,FOLLOW_66); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getAccessExprAccess().getRightCurlyBracketKeyword_1_1_2());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpear.g:4597:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    {
            	    // InternalSpear.g:4597:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    // InternalSpear.g:4597:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']'
            	    {
            	    // InternalSpear.g:4597:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) )
            	    // InternalSpear.g:4597:8: ( ( () '[' ) )=> ( () otherlv_11= '[' )
            	    {
            	    // InternalSpear.g:4599:5: ( () otherlv_11= '[' )
            	    // InternalSpear.g:4599:6: () otherlv_11= '['
            	    {
            	    // InternalSpear.g:4599:6: ()
            	    // InternalSpear.g:4600:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getArrayAccessExprArrayAction_1_2_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_11=(Token)match(input,53,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getAccessExprAccess().getLeftSquareBracketKeyword_1_2_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4609:3: ( (lv_index_12_0= ruleExpr ) )
            	    // InternalSpear.g:4610:1: (lv_index_12_0= ruleExpr )
            	    {
            	    // InternalSpear.g:4610:1: (lv_index_12_0= ruleExpr )
            	    // InternalSpear.g:4611:3: lv_index_12_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getIndexExprParserRuleCall_1_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_69);
            	    lv_index_12_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"index",
            	              		lv_index_12_0, 
            	              		"com.rockwellcollins.Spear.Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4627:2: ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )?
            	    int alt92=2;
            	    int LA92_0 = input.LA(1);

            	    if ( (LA92_0==111) && (synpred17_InternalSpear())) {
            	        alt92=1;
            	    }
            	    switch (alt92) {
            	        case 1 :
            	            // InternalSpear.g:4627:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) )
            	            {
            	            // InternalSpear.g:4627:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) )
            	            // InternalSpear.g:4627:4: ( ( () ':=' ) )=> ( () otherlv_14= ':=' )
            	            {
            	            // InternalSpear.g:4629:5: ( () otherlv_14= ':=' )
            	            // InternalSpear.g:4629:6: () otherlv_14= ':='
            	            {
            	            // InternalSpear.g:4629:6: ()
            	            // InternalSpear.g:4630:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAccessExprAccess().getArrayUpdateExprAccessAction_1_2_2_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_14=(Token)match(input,111,FOLLOW_32); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_2_2_0_0_1());
            	                  
            	            }

            	            }


            	            }

            	            // InternalSpear.g:4639:3: ( (lv_value_15_0= ruleExpr ) )
            	            // InternalSpear.g:4640:1: (lv_value_15_0= ruleExpr )
            	            {
            	            // InternalSpear.g:4640:1: (lv_value_15_0= ruleExpr )
            	            // InternalSpear.g:4641:3: lv_value_15_0= ruleExpr
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_2_2_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_45);
            	            lv_value_15_0=ruleExpr();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getAccessExprRule());
            	              	        }
            	                     		set(
            	                     			current, 
            	                     			"value",
            	                      		lv_value_15_0, 
            	                      		"com.rockwellcollins.Spear.Expr");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_16=(Token)match(input,54,FOLLOW_66); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getAccessExprAccess().getRightSquareBracketKeyword_1_2_3());
            	          
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessExpr"


    // $ANTLR start "entryRuleAtomicExpr"
    // InternalSpear.g:4669:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalSpear.g:4670:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalSpear.g:4671:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpr=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpr"


    // $ANTLR start "ruleAtomicExpr"
    // InternalSpear.g:4678:1: ruleAtomicExpr returns [EObject current=null] : (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) ) ;
    public final EObject ruleAtomicExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        EObject this_LiteralExpr_0 = null;

        EObject lv_cond_11_0 = null;

        EObject lv_then_13_0 = null;

        EObject lv_else_15_0 = null;

        EObject lv_fieldExprs_20_0 = null;

        EObject lv_fieldExprs_22_0 = null;

        EObject lv_exprs_28_0 = null;

        EObject lv_exprs_30_0 = null;

        EObject lv_exprs_36_0 = null;

        EObject lv_exprs_38_0 = null;

        EObject lv_args_43_0 = null;

        EObject lv_args_45_0 = null;

        EObject lv_args_51_0 = null;

        EObject lv_args_53_0 = null;

        EObject this_UnusedExpr_55 = null;

        EObject this_Expr_57 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4681:28: ( (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) ) )
            // InternalSpear.g:4682:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )
            {
            // InternalSpear.g:4682:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )
            int alt103=11;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // InternalSpear.g:4683:5: this_LiteralExpr_0= ruleLiteralExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getLiteralExprParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralExpr_0=ruleLiteralExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LiteralExpr_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:4692:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalSpear.g:4692:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    // InternalSpear.g:4692:7: () ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSpear.g:4692:7: ()
                    // InternalSpear.g:4693:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4698:2: ( (otherlv_2= RULE_ID ) )
                    // InternalSpear.g:4699:1: (otherlv_2= RULE_ID )
                    {
                    // InternalSpear.g:4699:1: (otherlv_2= RULE_ID )
                    // InternalSpear.g:4700:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getAtomicExprAccess().getIdIdRefCrossReference_1_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:4712:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    {
                    // InternalSpear.g:4712:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    // InternalSpear.g:4712:7: () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|'
                    {
                    // InternalSpear.g:4712:7: ()
                    // InternalSpear.g:4713:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getMultipleIdExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,43,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_1());
                          
                    }
                    // InternalSpear.g:4722:1: ( (otherlv_5= RULE_ID ) )
                    // InternalSpear.g:4723:1: (otherlv_5= RULE_ID )
                    {
                    // InternalSpear.g:4723:1: (otherlv_5= RULE_ID )
                    // InternalSpear.g:4724:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_2_0()); 
                      	
                    }

                    }


                    }

                    // InternalSpear.g:4735:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==37) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalSpear.g:4735:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getAtomicExprAccess().getCommaKeyword_2_3_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4739:1: ( (otherlv_7= RULE_ID ) )
                    	    // InternalSpear.g:4740:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalSpear.g:4740:1: (otherlv_7= RULE_ID )
                    	    // InternalSpear.g:4741:3: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_7, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop94;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_4());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:4757:6: ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? )
                    {
                    // InternalSpear.g:4757:6: ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? )
                    // InternalSpear.g:4757:7: () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )?
                    {
                    // InternalSpear.g:4757:7: ()
                    // InternalSpear.g:4758:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIfThenElseExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,112,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExprAccess().getIfKeyword_3_1());
                          
                    }
                    // InternalSpear.g:4767:1: ( (lv_cond_11_0= ruleExpr ) )
                    // InternalSpear.g:4768:1: (lv_cond_11_0= ruleExpr )
                    {
                    // InternalSpear.g:4768:1: (lv_cond_11_0= ruleExpr )
                    // InternalSpear.g:4769:3: lv_cond_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getCondExprParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_48);
                    lv_cond_11_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"cond",
                              		lv_cond_11_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,70,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getAtomicExprAccess().getThenKeyword_3_3());
                          
                    }
                    // InternalSpear.g:4789:1: ( (lv_then_13_0= ruleExpr ) )
                    // InternalSpear.g:4790:1: (lv_then_13_0= ruleExpr )
                    {
                    // InternalSpear.g:4790:1: (lv_then_13_0= ruleExpr )
                    // InternalSpear.g:4791:3: lv_then_13_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getThenExprParserRuleCall_3_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_70);
                    lv_then_13_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_13_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:4807:2: ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==113) ) {
                        int LA95_1 = input.LA(2);

                        if ( (synpred18_InternalSpear()) ) {
                            alt95=1;
                        }
                    }
                    switch (alt95) {
                        case 1 :
                            // InternalSpear.g:4807:3: ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) )
                            {
                            // InternalSpear.g:4807:3: ( ( 'else' )=>otherlv_14= 'else' )
                            // InternalSpear.g:4807:4: ( 'else' )=>otherlv_14= 'else'
                            {
                            otherlv_14=(Token)match(input,113,FOLLOW_32); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getAtomicExprAccess().getElseKeyword_3_5_0());
                                  
                            }

                            }

                            // InternalSpear.g:4812:2: ( (lv_else_15_0= ruleExpr ) )
                            // InternalSpear.g:4813:1: (lv_else_15_0= ruleExpr )
                            {
                            // InternalSpear.g:4813:1: (lv_else_15_0= ruleExpr )
                            // InternalSpear.g:4814:3: lv_else_15_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getElseExprParserRuleCall_3_5_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_else_15_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"else",
                                      		lv_else_15_0, 
                                      		"com.rockwellcollins.Spear.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSpear.g:4831:6: ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' )
                    {
                    // InternalSpear.g:4831:6: ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' )
                    // InternalSpear.g:4831:7: () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}'
                    {
                    // InternalSpear.g:4831:7: ()
                    // InternalSpear.g:4832:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRecordExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_17=(Token)match(input,114,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getAtomicExprAccess().getNewKeyword_4_1());
                          
                    }
                    // InternalSpear.g:4841:1: ( (otherlv_18= RULE_ID ) )
                    // InternalSpear.g:4842:1: (otherlv_18= RULE_ID )
                    {
                    // InternalSpear.g:4842:1: (otherlv_18= RULE_ID )
                    // InternalSpear.g:4843:3: otherlv_18= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_18, grammarAccess.getAtomicExprAccess().getTypeRecordTypeDefCrossReference_4_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_4_3());
                          
                    }
                    // InternalSpear.g:4858:1: ( (lv_fieldExprs_20_0= ruleFieldExpr ) )
                    // InternalSpear.g:4859:1: (lv_fieldExprs_20_0= ruleFieldExpr )
                    {
                    // InternalSpear.g:4859:1: (lv_fieldExprs_20_0= ruleFieldExpr )
                    // InternalSpear.g:4860:3: lv_fieldExprs_20_0= ruleFieldExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsFieldExprParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
                    lv_fieldExprs_20_0=ruleFieldExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"fieldExprs",
                              		lv_fieldExprs_20_0, 
                              		"com.rockwellcollins.Spear.FieldExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:4876:2: (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==37) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalSpear.g:4876:4: otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) )
                    	    {
                    	    otherlv_21=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_21, grammarAccess.getAtomicExprAccess().getCommaKeyword_4_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4880:1: ( (lv_fieldExprs_22_0= ruleFieldExpr ) )
                    	    // InternalSpear.g:4881:1: (lv_fieldExprs_22_0= ruleFieldExpr )
                    	    {
                    	    // InternalSpear.g:4881:1: (lv_fieldExprs_22_0= ruleFieldExpr )
                    	    // InternalSpear.g:4882:3: lv_fieldExprs_22_0= ruleFieldExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsFieldExprParserRuleCall_4_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_fieldExprs_22_0=ruleFieldExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fieldExprs",
                    	              		lv_fieldExprs_22_0, 
                    	              		"com.rockwellcollins.Spear.FieldExpr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_4_6());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSpear.g:4903:6: ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' )
                    {
                    // InternalSpear.g:4903:6: ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' )
                    // InternalSpear.g:4903:7: () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}'
                    {
                    // InternalSpear.g:4903:7: ()
                    // InternalSpear.g:4904:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFieldlessRecordExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_25=(Token)match(input,114,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getAtomicExprAccess().getNewKeyword_5_1());
                          
                    }
                    // InternalSpear.g:4913:1: ( (otherlv_26= RULE_ID ) )
                    // InternalSpear.g:4914:1: (otherlv_26= RULE_ID )
                    {
                    // InternalSpear.g:4914:1: (otherlv_26= RULE_ID )
                    // InternalSpear.g:4915:3: otherlv_26= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_26=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_26, grammarAccess.getAtomicExprAccess().getTypeRecordTypeDefCrossReference_5_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,51,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_5_3());
                          
                    }
                    // InternalSpear.g:4930:1: ( (lv_exprs_28_0= ruleExpr ) )
                    // InternalSpear.g:4931:1: (lv_exprs_28_0= ruleExpr )
                    {
                    // InternalSpear.g:4931:1: (lv_exprs_28_0= ruleExpr )
                    // InternalSpear.g:4932:3: lv_exprs_28_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_5_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
                    lv_exprs_28_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"exprs",
                              		lv_exprs_28_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:4948:2: (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==37) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalSpear.g:4948:4: otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) )
                    	    {
                    	    otherlv_29=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_29, grammarAccess.getAtomicExprAccess().getCommaKeyword_5_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4952:1: ( (lv_exprs_30_0= ruleExpr ) )
                    	    // InternalSpear.g:4953:1: (lv_exprs_30_0= ruleExpr )
                    	    {
                    	    // InternalSpear.g:4953:1: (lv_exprs_30_0= ruleExpr )
                    	    // InternalSpear.g:4954:3: lv_exprs_30_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_5_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_exprs_30_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exprs",
                    	              		lv_exprs_30_0, 
                    	              		"com.rockwellcollins.Spear.Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop97;
                        }
                    } while (true);

                    otherlv_31=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_5_6());
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSpear.g:4975:6: ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' )
                    {
                    // InternalSpear.g:4975:6: ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' )
                    // InternalSpear.g:4975:7: () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']'
                    {
                    // InternalSpear.g:4975:7: ()
                    // InternalSpear.g:4976:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getArrayExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_33=(Token)match(input,114,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getAtomicExprAccess().getNewKeyword_6_1());
                          
                    }
                    // InternalSpear.g:4985:1: ( (otherlv_34= RULE_ID ) )
                    // InternalSpear.g:4986:1: (otherlv_34= RULE_ID )
                    {
                    // InternalSpear.g:4986:1: (otherlv_34= RULE_ID )
                    // InternalSpear.g:4987:3: otherlv_34= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_34, grammarAccess.getAtomicExprAccess().getTypeArrayTypeDefCrossReference_6_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_35=(Token)match(input,53,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_6_3());
                          
                    }
                    // InternalSpear.g:5002:1: ( (lv_exprs_36_0= ruleExpr ) )
                    // InternalSpear.g:5003:1: (lv_exprs_36_0= ruleExpr )
                    {
                    // InternalSpear.g:5003:1: (lv_exprs_36_0= ruleExpr )
                    // InternalSpear.g:5004:3: lv_exprs_36_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_47);
                    lv_exprs_36_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		add(
                             			current, 
                             			"exprs",
                              		lv_exprs_36_0, 
                              		"com.rockwellcollins.Spear.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:5020:2: (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==37) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalSpear.g:5020:4: otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) )
                    	    {
                    	    otherlv_37=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_37, grammarAccess.getAtomicExprAccess().getCommaKeyword_6_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:5024:1: ( (lv_exprs_38_0= ruleExpr ) )
                    	    // InternalSpear.g:5025:1: (lv_exprs_38_0= ruleExpr )
                    	    {
                    	    // InternalSpear.g:5025:1: (lv_exprs_38_0= ruleExpr )
                    	    // InternalSpear.g:5026:3: lv_exprs_38_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_47);
                    	    lv_exprs_38_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exprs",
                    	              		lv_exprs_38_0, 
                    	              		"com.rockwellcollins.Spear.Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_39, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalSpear.g:5047:6: ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' )
                    {
                    // InternalSpear.g:5047:6: ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' )
                    // InternalSpear.g:5047:7: () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')'
                    {
                    // InternalSpear.g:5047:7: ()
                    // InternalSpear.g:5048:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getPatternCallAction_7_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:5053:2: ( (otherlv_41= RULE_ID ) )
                    // InternalSpear.g:5054:1: (otherlv_41= RULE_ID )
                    {
                    // InternalSpear.g:5054:1: (otherlv_41= RULE_ID )
                    // InternalSpear.g:5055:3: otherlv_41= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_41=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_41, grammarAccess.getAtomicExprAccess().getPatternPatternCrossReference_7_1_0()); 
                      	
                    }

                    }


                    }

                    otherlv_42=(Token)match(input,36,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_7_2());
                          
                    }
                    // InternalSpear.g:5070:1: ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==RULE_ID||LA100_0==RULE_INT||LA100_0==36||LA100_0==43||LA100_0==69||LA100_0==76||(LA100_0>=82 && LA100_0<=88)||LA100_0==100||LA100_0==102||LA100_0==106||LA100_0==112||(LA100_0>=114 && LA100_0<=120)) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // InternalSpear.g:5070:2: ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )*
                            {
                            // InternalSpear.g:5070:2: ( (lv_args_43_0= ruleExpr ) )
                            // InternalSpear.g:5071:1: (lv_args_43_0= ruleExpr )
                            {
                            // InternalSpear.g:5071:1: (lv_args_43_0= ruleExpr )
                            // InternalSpear.g:5072:3: lv_args_43_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_7_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_24);
                            lv_args_43_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_43_0, 
                                      		"com.rockwellcollins.Spear.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpear.g:5088:2: (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )*
                            loop99:
                            do {
                                int alt99=2;
                                int LA99_0 = input.LA(1);

                                if ( (LA99_0==37) ) {
                                    alt99=1;
                                }


                                switch (alt99) {
                            	case 1 :
                            	    // InternalSpear.g:5088:4: otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) )
                            	    {
                            	    otherlv_44=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_44, grammarAccess.getAtomicExprAccess().getCommaKeyword_7_3_1_0());
                            	          
                            	    }
                            	    // InternalSpear.g:5092:1: ( (lv_args_45_0= ruleExpr ) )
                            	    // InternalSpear.g:5093:1: (lv_args_45_0= ruleExpr )
                            	    {
                            	    // InternalSpear.g:5093:1: (lv_args_45_0= ruleExpr )
                            	    // InternalSpear.g:5094:3: lv_args_45_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_7_3_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_24);
                            	    lv_args_45_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_45_0, 
                            	              		"com.rockwellcollins.Spear.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop99;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_46=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_46, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_7_4());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSpear.g:5115:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' )
                    {
                    // InternalSpear.g:5115:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' )
                    // InternalSpear.g:5115:7: () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')'
                    {
                    // InternalSpear.g:5115:7: ()
                    // InternalSpear.g:5116:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSpecificationCallAction_8_0(),
                                  current);
                          
                    }

                    }

                    otherlv_48=(Token)match(input,115,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_48, grammarAccess.getAtomicExprAccess().getSpecKeyword_8_1());
                          
                    }
                    // InternalSpear.g:5125:1: ( (otherlv_49= RULE_ID ) )
                    // InternalSpear.g:5126:1: (otherlv_49= RULE_ID )
                    {
                    // InternalSpear.g:5126:1: (otherlv_49= RULE_ID )
                    // InternalSpear.g:5127:3: otherlv_49= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_49=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_49, grammarAccess.getAtomicExprAccess().getSpecSpecificationCrossReference_8_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_50=(Token)match(input,36,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_50, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_8_3());
                          
                    }
                    // InternalSpear.g:5142:1: ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )?
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==RULE_ID||LA102_0==RULE_INT||LA102_0==36||LA102_0==43||LA102_0==69||LA102_0==76||(LA102_0>=82 && LA102_0<=88)||LA102_0==100||LA102_0==102||LA102_0==106||LA102_0==112||(LA102_0>=114 && LA102_0<=120)) ) {
                        alt102=1;
                    }
                    switch (alt102) {
                        case 1 :
                            // InternalSpear.g:5142:2: ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )*
                            {
                            // InternalSpear.g:5142:2: ( (lv_args_51_0= ruleExpr ) )
                            // InternalSpear.g:5143:1: (lv_args_51_0= ruleExpr )
                            {
                            // InternalSpear.g:5143:1: (lv_args_51_0= ruleExpr )
                            // InternalSpear.g:5144:3: lv_args_51_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_8_4_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_24);
                            lv_args_51_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_51_0, 
                                      		"com.rockwellcollins.Spear.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalSpear.g:5160:2: (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )*
                            loop101:
                            do {
                                int alt101=2;
                                int LA101_0 = input.LA(1);

                                if ( (LA101_0==37) ) {
                                    alt101=1;
                                }


                                switch (alt101) {
                            	case 1 :
                            	    // InternalSpear.g:5160:4: otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) )
                            	    {
                            	    otherlv_52=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_52, grammarAccess.getAtomicExprAccess().getCommaKeyword_8_4_1_0());
                            	          
                            	    }
                            	    // InternalSpear.g:5164:1: ( (lv_args_53_0= ruleExpr ) )
                            	    // InternalSpear.g:5165:1: (lv_args_53_0= ruleExpr )
                            	    {
                            	    // InternalSpear.g:5165:1: (lv_args_53_0= ruleExpr )
                            	    // InternalSpear.g:5166:3: lv_args_53_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_8_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_24);
                            	    lv_args_53_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_53_0, 
                            	              		"com.rockwellcollins.Spear.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop101;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_54=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_8_5());
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalSpear.g:5188:5: this_UnusedExpr_55= ruleUnusedExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getUnusedExprParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_UnusedExpr_55=ruleUnusedExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnusedExpr_55; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalSpear.g:5197:6: (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' )
                    {
                    // InternalSpear.g:5197:6: (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' )
                    // InternalSpear.g:5197:8: otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')'
                    {
                    otherlv_56=(Token)match(input,36,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_56, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_10_1()); 
                          
                    }
                    pushFollow(FOLLOW_38);
                    this_Expr_57=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_57; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_58=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_58, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_10_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpr"


    // $ANTLR start "entryRuleLiteralExpr"
    // InternalSpear.g:5222:1: entryRuleLiteralExpr returns [EObject current=null] : iv_ruleLiteralExpr= ruleLiteralExpr EOF ;
    public final EObject entryRuleLiteralExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpr = null;


        try {
            // InternalSpear.g:5223:2: (iv_ruleLiteralExpr= ruleLiteralExpr EOF )
            // InternalSpear.g:5224:2: iv_ruleLiteralExpr= ruleLiteralExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpr=ruleLiteralExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpr"


    // $ANTLR start "ruleLiteralExpr"
    // InternalSpear.g:5231:1: ruleLiteralExpr returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) ;
    public final EObject ruleLiteralExpr() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        AntlrDatatypeRuleToken lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5234:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) )
            // InternalSpear.g:5235:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            {
            // InternalSpear.g:5235:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            int alt106=3;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_INT) ) {
                int LA106_1 = input.LA(2);

                if ( (LA106_1==110) ) {
                    int LA106_3 = input.LA(3);

                    if ( ((LA106_3>=RULE_INT && LA106_3<=RULE_EXT_INT)) ) {
                        alt106=3;
                    }
                    else if ( (LA106_3==RULE_ID) ) {
                        alt106=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA106_1==EOF||LA106_1==RULE_ID||(LA106_1>=17 && LA106_1<=18)||(LA106_1>=23 && LA106_1<=32)||(LA106_1>=37 && LA106_1<=38)||(LA106_1>=42 && LA106_1<=43)||(LA106_1>=45 && LA106_1<=48)||(LA106_1>=51 && LA106_1<=54)||(LA106_1>=61 && LA106_1<=68)||(LA106_1>=70 && LA106_1<=75)||(LA106_1>=77 && LA106_1<=81)||(LA106_1>=89 && LA106_1<=90)||(LA106_1>=92 && LA106_1<=93)||(LA106_1>=95 && LA106_1<=105)||LA106_1==107||LA106_1==111||LA106_1==113) ) {
                    alt106=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA106_0>=117 && LA106_0<=120)) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalSpear.g:5235:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    {
                    // InternalSpear.g:5235:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    // InternalSpear.g:5235:3: () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )?
                    {
                    // InternalSpear.g:5235:3: ()
                    // InternalSpear.g:5236:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getIntLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:5241:2: ( (lv_value_1_0= RULE_INT ) )
                    // InternalSpear.g:5242:1: (lv_value_1_0= RULE_INT )
                    {
                    // InternalSpear.g:5242:1: (lv_value_1_0= RULE_INT )
                    // InternalSpear.g:5243:3: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getLiteralExprAccess().getValueINTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:5259:2: ( (otherlv_2= RULE_ID ) )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==RULE_ID) ) {
                        int LA104_1 = input.LA(2);

                        if ( (LA104_1==EOF||LA104_1==RULE_ID||(LA104_1>=17 && LA104_1<=18)||(LA104_1>=23 && LA104_1<=32)||(LA104_1>=37 && LA104_1<=38)||(LA104_1>=42 && LA104_1<=43)||(LA104_1>=45 && LA104_1<=48)||(LA104_1>=51 && LA104_1<=54)||(LA104_1>=61 && LA104_1<=68)||(LA104_1>=70 && LA104_1<=75)||(LA104_1>=77 && LA104_1<=81)||(LA104_1>=89 && LA104_1<=90)||(LA104_1>=92 && LA104_1<=93)||(LA104_1>=95 && LA104_1<=105)||LA104_1==107||(LA104_1>=110 && LA104_1<=111)||LA104_1==113) ) {
                            alt104=1;
                        }
                    }
                    switch (alt104) {
                        case 1 :
                            // InternalSpear.g:5260:1: (otherlv_2= RULE_ID )
                            {
                            // InternalSpear.g:5260:1: (otherlv_2= RULE_ID )
                            // InternalSpear.g:5261:3: otherlv_2= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralExprRule());
                              	        }
                                      
                            }
                            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_2, grammarAccess.getLiteralExprAccess().getUnitUnitDefCrossReference_0_2_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:5273:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    {
                    // InternalSpear.g:5273:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    // InternalSpear.g:5273:7: () ( (lv_value_4_0= ruleBOOL ) )
                    {
                    // InternalSpear.g:5273:7: ()
                    // InternalSpear.g:5274:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getBoolLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:5279:2: ( (lv_value_4_0= ruleBOOL ) )
                    // InternalSpear.g:5280:1: (lv_value_4_0= ruleBOOL )
                    {
                    // InternalSpear.g:5280:1: (lv_value_4_0= ruleBOOL )
                    // InternalSpear.g:5281:3: lv_value_4_0= ruleBOOL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralExprAccess().getValueBOOLParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleBOOL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralExprRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"com.rockwellcollins.Spear.BOOL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:5298:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    {
                    // InternalSpear.g:5298:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    // InternalSpear.g:5298:7: () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )?
                    {
                    // InternalSpear.g:5298:7: ()
                    // InternalSpear.g:5299:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getRealLiteralAction_2_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:5304:2: ( (lv_value_6_0= ruleREAL ) )
                    // InternalSpear.g:5305:1: (lv_value_6_0= ruleREAL )
                    {
                    // InternalSpear.g:5305:1: (lv_value_6_0= ruleREAL )
                    // InternalSpear.g:5306:3: lv_value_6_0= ruleREAL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralExprAccess().getValueREALParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_value_6_0=ruleREAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralExprRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"com.rockwellcollins.Spear.REAL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:5322:2: ( (otherlv_7= RULE_ID ) )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==RULE_ID) ) {
                        int LA105_1 = input.LA(2);

                        if ( (LA105_1==EOF||LA105_1==RULE_ID||(LA105_1>=17 && LA105_1<=18)||(LA105_1>=23 && LA105_1<=32)||(LA105_1>=37 && LA105_1<=38)||(LA105_1>=42 && LA105_1<=43)||(LA105_1>=45 && LA105_1<=48)||(LA105_1>=51 && LA105_1<=54)||(LA105_1>=61 && LA105_1<=68)||(LA105_1>=70 && LA105_1<=75)||(LA105_1>=77 && LA105_1<=81)||(LA105_1>=89 && LA105_1<=90)||(LA105_1>=92 && LA105_1<=93)||(LA105_1>=95 && LA105_1<=105)||LA105_1==107||(LA105_1>=110 && LA105_1<=111)||LA105_1==113) ) {
                            alt105=1;
                        }
                    }
                    switch (alt105) {
                        case 1 :
                            // InternalSpear.g:5323:1: (otherlv_7= RULE_ID )
                            {
                            // InternalSpear.g:5323:1: (otherlv_7= RULE_ID )
                            // InternalSpear.g:5324:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralExprRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getLiteralExprAccess().getUnitUnitDefCrossReference_2_2_0()); 
                              	
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpr"


    // $ANTLR start "entryRuleUnusedExpr"
    // InternalSpear.g:5343:1: entryRuleUnusedExpr returns [EObject current=null] : iv_ruleUnusedExpr= ruleUnusedExpr EOF ;
    public final EObject entryRuleUnusedExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnusedExpr = null;


        try {
            // InternalSpear.g:5344:2: (iv_ruleUnusedExpr= ruleUnusedExpr EOF )
            // InternalSpear.g:5345:2: iv_ruleUnusedExpr= ruleUnusedExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnusedExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnusedExpr=ruleUnusedExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnusedExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnusedExpr"


    // $ANTLR start "ruleUnusedExpr"
    // InternalSpear.g:5352:1: ruleUnusedExpr returns [EObject current=null] : ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' ) ;
    public final EObject ruleUnusedExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_args_10_0 = null;

        EObject lv_args_12_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5355:28: ( ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' ) )
            // InternalSpear.g:5356:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' )
            {
            // InternalSpear.g:5356:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' )
            // InternalSpear.g:5356:2: () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')'
            {
            // InternalSpear.g:5356:2: ()
            // InternalSpear.g:5357:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnusedExprAccess().getNormalizedCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,116,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnusedExprAccess().getNumberSignKeyword_1());
                  
            }
            // InternalSpear.g:5366:1: ( (otherlv_2= RULE_ID ) )
            // InternalSpear.g:5367:1: (otherlv_2= RULE_ID )
            {
            // InternalSpear.g:5367:1: (otherlv_2= RULE_ID )
            // InternalSpear.g:5368:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUnusedExprRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getUnusedExprAccess().getIdsIdRefCrossReference_2_0()); 
              	
            }

            }


            }

            // InternalSpear.g:5379:2: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==37) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalSpear.g:5379:4: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getUnusedExprAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalSpear.g:5383:1: ( (otherlv_4= RULE_ID ) )
            	    // InternalSpear.g:5384:1: (otherlv_4= RULE_ID )
            	    {
            	    // InternalSpear.g:5384:1: (otherlv_4= RULE_ID )
            	    // InternalSpear.g:5385:3: otherlv_4= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getUnusedExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_72); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_4, grammarAccess.getUnusedExprAccess().getIdsIdRefCrossReference_3_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_5=(Token)match(input,116,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getUnusedExprAccess().getNumberSignKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,98,FOLLOW_74); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getUnusedExprAccess().getEqualsSignEqualsSignKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,115,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getUnusedExprAccess().getSpecKeyword_6());
                  
            }
            // InternalSpear.g:5408:1: ( (otherlv_8= RULE_ID ) )
            // InternalSpear.g:5409:1: (otherlv_8= RULE_ID )
            {
            // InternalSpear.g:5409:1: (otherlv_8= RULE_ID )
            // InternalSpear.g:5410:3: otherlv_8= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUnusedExprRule());
              	        }
                      
            }
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_8, grammarAccess.getUnusedExprAccess().getSpecSpecificationCrossReference_7_0()); 
              	
            }

            }


            }

            otherlv_9=(Token)match(input,36,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getUnusedExprAccess().getLeftParenthesisKeyword_8());
                  
            }
            // InternalSpear.g:5425:1: ( (lv_args_10_0= ruleExpr ) )
            // InternalSpear.g:5426:1: (lv_args_10_0= ruleExpr )
            {
            // InternalSpear.g:5426:1: (lv_args_10_0= ruleExpr )
            // InternalSpear.g:5427:3: lv_args_10_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnusedExprAccess().getArgsExprParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
            lv_args_10_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnusedExprRule());
              	        }
                     		add(
                     			current, 
                     			"args",
                      		lv_args_10_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalSpear.g:5443:2: (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==37) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalSpear.g:5443:4: otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) )
            	    {
            	    otherlv_11=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getUnusedExprAccess().getCommaKeyword_10_0());
            	          
            	    }
            	    // InternalSpear.g:5447:1: ( (lv_args_12_0= ruleExpr ) )
            	    // InternalSpear.g:5448:1: (lv_args_12_0= ruleExpr )
            	    {
            	    // InternalSpear.g:5448:1: (lv_args_12_0= ruleExpr )
            	    // InternalSpear.g:5449:3: lv_args_12_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnusedExprAccess().getArgsExprParserRuleCall_10_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_args_12_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnusedExprRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"args",
            	              		lv_args_12_0, 
            	              		"com.rockwellcollins.Spear.Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            otherlv_13=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getUnusedExprAccess().getRightParenthesisKeyword_11());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnusedExpr"


    // $ANTLR start "entryRuleFieldExpr"
    // InternalSpear.g:5479:1: entryRuleFieldExpr returns [EObject current=null] : iv_ruleFieldExpr= ruleFieldExpr EOF ;
    public final EObject entryRuleFieldExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldExpr = null;


        try {
            // InternalSpear.g:5480:2: (iv_ruleFieldExpr= ruleFieldExpr EOF )
            // InternalSpear.g:5481:2: iv_ruleFieldExpr= ruleFieldExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFieldExpr=ruleFieldExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldExpr"


    // $ANTLR start "ruleFieldExpr"
    // InternalSpear.g:5488:1: ruleFieldExpr returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) ;
    public final EObject ruleFieldExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5491:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) )
            // InternalSpear.g:5492:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            {
            // InternalSpear.g:5492:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            // InternalSpear.g:5492:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) )
            {
            // InternalSpear.g:5492:2: ( (otherlv_0= RULE_ID ) )
            // InternalSpear.g:5493:1: (otherlv_0= RULE_ID )
            {
            // InternalSpear.g:5493:1: (otherlv_0= RULE_ID )
            // InternalSpear.g:5494:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldExprRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldExprAccess().getFieldFieldTypeCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,44,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldExprAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalSpear.g:5509:1: ( (lv_expr_2_0= ruleExpr ) )
            // InternalSpear.g:5510:1: (lv_expr_2_0= ruleExpr )
            {
            // InternalSpear.g:5510:1: (lv_expr_2_0= ruleExpr )
            // InternalSpear.g:5511:3: lv_expr_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldExprAccess().getExprExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldExprRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"com.rockwellcollins.Spear.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldExpr"


    // $ANTLR start "entryRuleBOOL"
    // InternalSpear.g:5535:1: entryRuleBOOL returns [String current=null] : iv_ruleBOOL= ruleBOOL EOF ;
    public final String entryRuleBOOL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOL = null;


        try {
            // InternalSpear.g:5536:2: (iv_ruleBOOL= ruleBOOL EOF )
            // InternalSpear.g:5537:2: iv_ruleBOOL= ruleBOOL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBOOL=ruleBOOL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOL.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOL"


    // $ANTLR start "ruleBOOL"
    // InternalSpear.g:5544:1: ruleBOOL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBOOL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BOOLEAN_TRUE_0 = null;

        AntlrDatatypeRuleToken this_BOOLEAN_FALSE_1 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5547:28: ( (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) )
            // InternalSpear.g:5548:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            {
            // InternalSpear.g:5548:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( ((LA109_0>=117 && LA109_0<=118)) ) {
                alt109=1;
            }
            else if ( ((LA109_0>=119 && LA109_0<=120)) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalSpear.g:5549:5: this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBOOLAccess().getBOOLEAN_TRUEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BOOLEAN_TRUE_0=ruleBOOLEAN_TRUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BOOLEAN_TRUE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5561:5: this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBOOLAccess().getBOOLEAN_FALSEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_BOOLEAN_FALSE_1=ruleBOOLEAN_FALSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BOOLEAN_FALSE_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOL"


    // $ANTLR start "entryRuleBOOLEAN_TRUE"
    // InternalSpear.g:5579:1: entryRuleBOOLEAN_TRUE returns [String current=null] : iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF ;
    public final String entryRuleBOOLEAN_TRUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_TRUE = null;


        try {
            // InternalSpear.g:5580:2: (iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF )
            // InternalSpear.g:5581:2: iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLEAN_TRUERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBOOLEAN_TRUE=ruleBOOLEAN_TRUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOLEAN_TRUE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN_TRUE"


    // $ANTLR start "ruleBOOLEAN_TRUE"
    // InternalSpear.g:5588:1: ruleBOOLEAN_TRUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TRUE' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_TRUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:5591:28: ( (kw= 'TRUE' | kw= 'true' ) )
            // InternalSpear.g:5592:1: (kw= 'TRUE' | kw= 'true' )
            {
            // InternalSpear.g:5592:1: (kw= 'TRUE' | kw= 'true' )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==117) ) {
                alt110=1;
            }
            else if ( (LA110_0==118) ) {
                alt110=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalSpear.g:5593:2: kw= 'TRUE'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_TRUEAccess().getTRUEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5600:2: kw= 'true'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_TRUEAccess().getTrueKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_TRUE"


    // $ANTLR start "entryRuleBOOLEAN_FALSE"
    // InternalSpear.g:5613:1: entryRuleBOOLEAN_FALSE returns [String current=null] : iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF ;
    public final String entryRuleBOOLEAN_FALSE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_FALSE = null;


        try {
            // InternalSpear.g:5614:2: (iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF )
            // InternalSpear.g:5615:2: iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBOOLEAN_FALSERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBOOLEAN_FALSE=ruleBOOLEAN_FALSE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBOOLEAN_FALSE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN_FALSE"


    // $ANTLR start "ruleBOOLEAN_FALSE"
    // InternalSpear.g:5622:1: ruleBOOLEAN_FALSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'FALSE' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_FALSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:5625:28: ( (kw= 'FALSE' | kw= 'false' ) )
            // InternalSpear.g:5626:1: (kw= 'FALSE' | kw= 'false' )
            {
            // InternalSpear.g:5626:1: (kw= 'FALSE' | kw= 'false' )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==119) ) {
                alt111=1;
            }
            else if ( (LA111_0==120) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalSpear.g:5627:2: kw= 'FALSE'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_FALSEAccess().getFALSEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5634:2: kw= 'false'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_FALSEAccess().getFalseKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_FALSE"


    // $ANTLR start "entryRuleREAL"
    // InternalSpear.g:5647:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // InternalSpear.g:5651:2: (iv_ruleREAL= ruleREAL EOF )
            // InternalSpear.g:5652:2: iv_ruleREAL= ruleREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getREALRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleREAL=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREAL.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // InternalSpear.g:5662:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_EXT_INT_2=null;
        Token this_INT_3=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // InternalSpear.g:5666:28: ( (this_INT_0= RULE_INT kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) ) )
            // InternalSpear.g:5667:1: (this_INT_0= RULE_INT kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            {
            // InternalSpear.g:5667:1: (this_INT_0= RULE_INT kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT ) )
            // InternalSpear.g:5667:6: this_INT_0= RULE_INT kw= '.' (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,110,FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                  
            }
            // InternalSpear.g:5680:1: (this_EXT_INT_2= RULE_EXT_INT | this_INT_3= RULE_INT )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_EXT_INT) ) {
                alt112=1;
            }
            else if ( (LA112_0==RULE_INT) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalSpear.g:5680:6: this_EXT_INT_2= RULE_EXT_INT
                    {
                    this_EXT_INT_2=(Token)match(input,RULE_EXT_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXT_INT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXT_INT_2, grammarAccess.getREALAccess().getEXT_INTTerminalRuleCall_2_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5688:10: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_3, grammarAccess.getREALAccess().getINTTerminalRuleCall_2_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleREAL"

    // $ANTLR start synpred1_InternalSpear
    public final void synpred1_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:1430:3: ( ( () ( ( '*' ) ) ) )
        // InternalSpear.g:1430:4: ( () ( ( '*' ) ) )
        {
        // InternalSpear.g:1430:4: ( () ( ( '*' ) ) )
        // InternalSpear.g:1430:5: () ( ( '*' ) )
        {
        // InternalSpear.g:1430:5: ()
        // InternalSpear.g:1431:1: 
        {
        }

        // InternalSpear.g:1431:2: ( ( '*' ) )
        // InternalSpear.g:1432:1: ( '*' )
        {
        // InternalSpear.g:1432:1: ( '*' )
        // InternalSpear.g:1433:2: '*'
        {
        match(input,47,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSpear

    // $ANTLR start synpred2_InternalSpear
    public final void synpred2_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:1506:3: ( ( () ( ( '/' ) ) ) )
        // InternalSpear.g:1506:4: ( () ( ( '/' ) ) )
        {
        // InternalSpear.g:1506:4: ( () ( ( '/' ) ) )
        // InternalSpear.g:1506:5: () ( ( '/' ) )
        {
        // InternalSpear.g:1506:5: ()
        // InternalSpear.g:1507:1: 
        {
        }

        // InternalSpear.g:1507:2: ( ( '/' ) )
        // InternalSpear.g:1508:1: ( '/' )
        {
        // InternalSpear.g:1508:1: ( '/' )
        // InternalSpear.g:1509:2: '/'
        {
        match(input,48,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSpear

    // $ANTLR start synpred3_InternalSpear
    public final void synpred3_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3112:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )
        // InternalSpear.g:3112:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        {
        // InternalSpear.g:3112:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        // InternalSpear.g:3112:5: () ( ( ( '=>' | 'implies' ) ) )
        {
        // InternalSpear.g:3112:5: ()
        // InternalSpear.g:3113:1: 
        {
        }

        // InternalSpear.g:3113:2: ( ( ( '=>' | 'implies' ) ) )
        // InternalSpear.g:3114:1: ( ( '=>' | 'implies' ) )
        {
        // InternalSpear.g:3114:1: ( ( '=>' | 'implies' ) )
        // InternalSpear.g:3115:1: ( '=>' | 'implies' )
        {
        if ( (input.LA(1)>=71 && input.LA(1)<=72) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSpear

    // $ANTLR start synpred4_InternalSpear
    public final void synpred4_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3209:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )
        // InternalSpear.g:3209:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        {
        // InternalSpear.g:3209:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        // InternalSpear.g:3209:5: () ( ( ( 'or' | 'xor' ) ) )
        {
        // InternalSpear.g:3209:5: ()
        // InternalSpear.g:3210:1: 
        {
        }

        // InternalSpear.g:3210:2: ( ( ( 'or' | 'xor' ) ) )
        // InternalSpear.g:3211:1: ( ( 'or' | 'xor' ) )
        {
        // InternalSpear.g:3211:1: ( ( 'or' | 'xor' ) )
        // InternalSpear.g:3212:1: ( 'or' | 'xor' )
        {
        if ( (input.LA(1)>=73 && input.LA(1)<=74) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSpear

    // $ANTLR start synpred5_InternalSpear
    public final void synpred5_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3306:3: ( ( () ( ( 'and' ) ) ) )
        // InternalSpear.g:3306:4: ( () ( ( 'and' ) ) )
        {
        // InternalSpear.g:3306:4: ( () ( ( 'and' ) ) )
        // InternalSpear.g:3306:5: () ( ( 'and' ) )
        {
        // InternalSpear.g:3306:5: ()
        // InternalSpear.g:3307:1: 
        {
        }

        // InternalSpear.g:3307:2: ( ( 'and' ) )
        // InternalSpear.g:3308:1: ( 'and' )
        {
        // InternalSpear.g:3308:1: ( 'and' )
        // InternalSpear.g:3309:2: 'and'
        {
        match(input,75,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalSpear

    // $ANTLR start synpred6_InternalSpear
    public final void synpred6_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3401:4: ( 'until' )
        // InternalSpear.g:3401:6: 'until'
        {
        match(input,77,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalSpear

    // $ANTLR start synpred7_InternalSpear
    public final void synpred7_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3464:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )
        // InternalSpear.g:3464:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        {
        // InternalSpear.g:3464:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        // InternalSpear.g:3464:5: () ( ( ( 'T' | 'triggers' ) ) )
        {
        // InternalSpear.g:3464:5: ()
        // InternalSpear.g:3465:1: 
        {
        }

        // InternalSpear.g:3465:2: ( ( ( 'T' | 'triggers' ) ) )
        // InternalSpear.g:3466:1: ( ( 'T' | 'triggers' ) )
        {
        // InternalSpear.g:3466:1: ( ( 'T' | 'triggers' ) )
        // InternalSpear.g:3467:1: ( 'T' | 'triggers' )
        {
        if ( (input.LA(1)>=78 && input.LA(1)<=79) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalSpear

    // $ANTLR start synpred8_InternalSpear
    public final void synpred8_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3561:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )
        // InternalSpear.g:3561:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        {
        // InternalSpear.g:3561:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        // InternalSpear.g:3561:5: () ( ( ( 'S' | 'since' ) ) )
        {
        // InternalSpear.g:3561:5: ()
        // InternalSpear.g:3562:1: 
        {
        }

        // InternalSpear.g:3562:2: ( ( ( 'S' | 'since' ) ) )
        // InternalSpear.g:3563:1: ( ( 'S' | 'since' ) )
        {
        // InternalSpear.g:3563:1: ( ( 'S' | 'since' ) )
        // InternalSpear.g:3564:1: ( 'S' | 'since' )
        {
        if ( (input.LA(1)>=80 && input.LA(1)<=81) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalSpear

    // $ANTLR start synpred9_InternalSpear
    public final void synpred9_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3803:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalSpear.g:3803:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalSpear.g:3803:4: ( () ( ( ruleRelationalOp ) ) )
        // InternalSpear.g:3803:5: () ( ( ruleRelationalOp ) )
        {
        // InternalSpear.g:3803:5: ()
        // InternalSpear.g:3804:1: 
        {
        }

        // InternalSpear.g:3804:2: ( ( ruleRelationalOp ) )
        // InternalSpear.g:3805:1: ( ruleRelationalOp )
        {
        // InternalSpear.g:3805:1: ( ruleRelationalOp )
        // InternalSpear.g:3806:1: ruleRelationalOp
        {
        pushFollow(FOLLOW_2);
        ruleRelationalOp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalSpear

    // $ANTLR start synpred10_InternalSpear
    public final void synpred10_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4062:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )
        // InternalSpear.g:4062:4: ( () ( ( ( '+' | '-' ) ) ) )
        {
        // InternalSpear.g:4062:4: ( () ( ( ( '+' | '-' ) ) ) )
        // InternalSpear.g:4062:5: () ( ( ( '+' | '-' ) ) )
        {
        // InternalSpear.g:4062:5: ()
        // InternalSpear.g:4063:1: 
        {
        }

        // InternalSpear.g:4063:2: ( ( ( '+' | '-' ) ) )
        // InternalSpear.g:4064:1: ( ( '+' | '-' ) )
        {
        // InternalSpear.g:4064:1: ( ( '+' | '-' ) )
        // InternalSpear.g:4065:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=101 && input.LA(1)<=102) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalSpear

    // $ANTLR start synpred11_InternalSpear
    public final void synpred11_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4159:3: ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )
        // InternalSpear.g:4159:4: ( () ( ( ( '*' | '/' | 'mod' ) ) ) )
        {
        // InternalSpear.g:4159:4: ( () ( ( ( '*' | '/' | 'mod' ) ) ) )
        // InternalSpear.g:4159:5: () ( ( ( '*' | '/' | 'mod' ) ) )
        {
        // InternalSpear.g:4159:5: ()
        // InternalSpear.g:4160:1: 
        {
        }

        // InternalSpear.g:4160:2: ( ( ( '*' | '/' | 'mod' ) ) )
        // InternalSpear.g:4161:1: ( ( '*' | '/' | 'mod' ) )
        {
        // InternalSpear.g:4161:1: ( ( '*' | '/' | 'mod' ) )
        // InternalSpear.g:4162:1: ( '*' | '/' | 'mod' )
        {
        if ( (input.LA(1)>=47 && input.LA(1)<=48)||input.LA(1)==103 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalSpear

    // $ANTLR start synpred12_InternalSpear
    public final void synpred12_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4271:3: ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )
        // InternalSpear.g:4271:4: ( () ( ( ( '->' | 'arrow' ) ) ) )
        {
        // InternalSpear.g:4271:4: ( () ( ( ( '->' | 'arrow' ) ) ) )
        // InternalSpear.g:4271:5: () ( ( ( '->' | 'arrow' ) ) )
        {
        // InternalSpear.g:4271:5: ()
        // InternalSpear.g:4272:1: 
        {
        }

        // InternalSpear.g:4272:2: ( ( ( '->' | 'arrow' ) ) )
        // InternalSpear.g:4273:1: ( ( '->' | 'arrow' ) )
        {
        // InternalSpear.g:4273:1: ( ( '->' | 'arrow' ) )
        // InternalSpear.g:4274:1: ( '->' | 'arrow' )
        {
        if ( (input.LA(1)>=104 && input.LA(1)<=105) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalSpear

    // $ANTLR start synpred13_InternalSpear
    public final void synpred13_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4442:4: ( 'with' )
        // InternalSpear.g:4442:6: 'with'
        {
        match(input,107,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalSpear

    // $ANTLR start synpred14_InternalSpear
    public final void synpred14_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4513:4: ( ( () '.' ) )
        // InternalSpear.g:4513:5: ( () '.' )
        {
        // InternalSpear.g:4513:5: ( () '.' )
        // InternalSpear.g:4513:6: () '.'
        {
        // InternalSpear.g:4513:6: ()
        // InternalSpear.g:4514:1: 
        {
        }

        match(input,110,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSpear

    // $ANTLR start synpred15_InternalSpear
    public final void synpred15_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4539:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )
        // InternalSpear.g:4539:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        {
        // InternalSpear.g:4539:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        // InternalSpear.g:4539:10: () '{' ( ( RULE_ID ) ) ':='
        {
        // InternalSpear.g:4539:10: ()
        // InternalSpear.g:4540:1: 
        {
        }

        match(input,51,FOLLOW_3); if (state.failed) return ;
        // InternalSpear.g:4541:1: ( ( RULE_ID ) )
        // InternalSpear.g:4542:1: ( RULE_ID )
        {
        // InternalSpear.g:4542:1: ( RULE_ID )
        // InternalSpear.g:4543:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_67); if (state.failed) return ;

        }


        }

        match(input,111,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalSpear

    // $ANTLR start synpred16_InternalSpear
    public final void synpred16_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4597:8: ( ( () '[' ) )
        // InternalSpear.g:4597:9: ( () '[' )
        {
        // InternalSpear.g:4597:9: ( () '[' )
        // InternalSpear.g:4597:10: () '['
        {
        // InternalSpear.g:4597:10: ()
        // InternalSpear.g:4598:1: 
        {
        }

        match(input,53,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalSpear

    // $ANTLR start synpred17_InternalSpear
    public final void synpred17_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4627:4: ( ( () ':=' ) )
        // InternalSpear.g:4627:5: ( () ':=' )
        {
        // InternalSpear.g:4627:5: ( () ':=' )
        // InternalSpear.g:4627:6: () ':='
        {
        // InternalSpear.g:4627:6: ()
        // InternalSpear.g:4628:1: 
        {
        }

        match(input,111,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalSpear

    // $ANTLR start synpred18_InternalSpear
    public final void synpred18_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4807:4: ( 'else' )
        // InternalSpear.g:4807:6: 'else'
        {
        match(input,113,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalSpear

    // Delegated rules

    public final boolean synpred2_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalSpear() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalSpear_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA55 dfa55 = new DFA55(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA103 dfa103 = new DFA103(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\7\uffff\4\14\3\uffff";
    static final String dfa_3s = "\1\4\1\26\3\4\2\uffff\4\4\3\uffff";
    static final String dfa_4s = "\1\4\1\74\3\72\2\uffff\4\65\3\uffff";
    static final String dfa_5s = "\5\uffff\1\5\1\2\4\uffff\1\3\1\1\1\4";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\44\uffff\1\3\1\4",
            "\1\12\54\uffff\1\6\1\13\4\uffff\1\5\1\7\1\10\1\11",
            "\1\12\54\uffff\1\6\1\13\4\uffff\1\5\1\7\1\10\1\11",
            "\1\12\54\uffff\1\6\1\13\4\uffff\1\5\1\7\1\10\1\11",
            "",
            "",
            "\1\14\13\uffff\3\14\42\uffff\1\15",
            "\1\14\13\uffff\3\14\42\uffff\1\15",
            "\1\14\13\uffff\3\14\42\uffff\1\15",
            "\1\14\13\uffff\3\14\42\uffff\1\15",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1631:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'abstract' ) | ( () ( (lv_name_10_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_12= 'record' otherlv_13= '{' ( (lv_fields_14_0= ruleFieldType ) ) (otherlv_15= ',' ( (lv_fields_16_0= ruleFieldType ) ) )* otherlv_17= '}' ) | ( () ( (lv_name_19_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_21_0= ruleType ) ) otherlv_22= '[' ( (lv_size_23_0= ruleExpr ) ) otherlv_24= ']' ) | ( () ( (lv_name_26_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_28= 'enum' otherlv_29= '{' ( (lv_values_30_0= ruleEnumValue ) ) (otherlv_31= ',' ( (lv_values_32_0= ruleEnumValue ) ) )* otherlv_33= '}' ) )";
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\13\14\uffff";
    static final String dfa_10s = "\1\4\12\0\2\uffff";
    static final String dfa_11s = "\1\161\12\0\2\uffff";
    static final String dfa_12s = "\13\uffff\1\2\1\1";
    static final String dfa_13s = "\1\uffff\1\7\1\6\1\3\1\11\1\0\1\4\1\1\1\5\1\10\1\2\2\uffff}>";
    static final String[] dfa_14s = {
            "\1\13\14\uffff\2\13\4\uffff\12\13\4\uffff\2\13\3\uffff\2\13\1\uffff\4\13\2\uffff\4\13\6\uffff\10\13\1\uffff\6\13\1\uffff\5\13\7\uffff\1\1\1\2\1\uffff\1\3\1\10\1\uffff\1\4\1\5\1\6\1\7\1\11\1\12\5\13\1\uffff\1\13\2\uffff\2\13\1\uffff\1\13",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3803:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_5 = input.LA(1);

                         
                        int index81_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA81_7 = input.LA(1);

                         
                        int index81_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA81_10 = input.LA(1);

                         
                        int index81_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA81_3 = input.LA(1);

                         
                        int index81_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA81_6 = input.LA(1);

                         
                        int index81_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA81_8 = input.LA(1);

                         
                        int index81_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA81_2 = input.LA(1);

                         
                        int index81_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_2);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA81_9 = input.LA(1);

                         
                        int index81_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA81_4 = input.LA(1);

                         
                        int index81_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index81_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\21\uffff";
    static final String dfa_16s = "\13\uffff\1\16\1\20\4\uffff";
    static final String dfa_17s = "\1\131\1\uffff\1\133\2\uffff\1\133\5\uffff\2\4\4\uffff";
    static final String dfa_18s = "\1\144\1\uffff\1\133\2\uffff\1\133\5\uffff\2\170\4\uffff";
    static final String dfa_19s = "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\7\1\11\1\12\1\13\1\14\2\uffff\1\4\1\2\1\10\1\6";
    static final String dfa_20s = "\21\uffff}>";
    static final String[] dfa_21s = {
            "\1\1\1\2\1\uffff\1\3\1\10\1\uffff\1\4\1\5\1\6\1\7\1\11\1\12",
            "",
            "\1\13",
            "",
            "",
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\16\35\uffff\1\16\6\uffff\1\16\35\uffff\1\15\32\uffff\1\16\1\uffff\1\16\3\uffff\1\16\5\uffff\1\16\1\uffff\7\16",
            "\1\20\1\uffff\1\20\35\uffff\1\20\6\uffff\1\20\35\uffff\1\17\32\uffff\1\20\1\uffff\1\20\3\uffff\1\20\5\uffff\1\20\1\uffff\7\20",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "3871:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )";
        }
    }
    static final String dfa_22s = "\2\uffff\1\11\16\uffff";
    static final String dfa_23s = "\1\4\1\uffff\1\4\2\uffff\1\4\5\uffff\1\63\1\4\1\uffff\1\44\2\uffff";
    static final String dfa_24s = "\1\170\1\uffff\1\161\2\uffff\1\4\5\uffff\1\65\1\170\1\uffff\1\156\2\uffff";
    static final String dfa_25s = "\1\uffff\1\1\1\uffff\1\3\1\4\1\uffff\1\11\1\12\1\13\1\2\1\10\2\uffff\1\7\1\uffff\1\6\1\5";
    static final String[] dfa_26s = {
            "\1\2\1\uffff\1\1\35\uffff\1\10\6\uffff\1\3\104\uffff\1\4\1\uffff\1\5\1\6\1\7\4\1",
            "",
            "\1\11\14\uffff\2\11\4\uffff\12\11\3\uffff\1\12\2\11\3\uffff\2\11\1\uffff\4\11\2\uffff\4\11\6\uffff\10\11\1\uffff\6\11\1\uffff\5\11\7\uffff\2\11\1\uffff\2\11\1\uffff\13\11\1\uffff\1\11\2\uffff\2\11\1\uffff\1\11",
            "",
            "",
            "\1\13",
            "",
            "",
            "",
            "",
            "",
            "\1\14\1\uffff\1\15",
            "\1\16\1\uffff\1\17\35\uffff\1\17\6\uffff\1\17\31\uffff\1\17\6\uffff\1\17\5\uffff\7\17\13\uffff\1\17\1\uffff\1\17\3\uffff\1\17\5\uffff\1\17\1\uffff\7\17",
            "",
            "\2\17\6\uffff\1\20\2\uffff\2\17\2\uffff\3\17\21\uffff\5\17\2\uffff\4\17\7\uffff\2\17\1\uffff\2\17\1\uffff\13\17\4\uffff\1\17",
            "",
            ""
    };
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_15;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_20;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4682:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000007E000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000020007C000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000078010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000070010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000003FB00010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000001C4000012L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000003E002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000020003C002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000038012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000030012L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00006C0000000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xE000000000000002L,0x000000000000001FL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000082000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000081000000050L,0x01FD045001FC1020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x1800000000400000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0700000000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010002000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040002000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000001FB6000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0001800000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000030000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0028000000000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0040000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000085000000050L,0x01FD045001FC1020L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000002000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x00000000000000C0L});

}