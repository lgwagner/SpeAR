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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Specification'", "'Imports:'", "'Units:'", "'Types:'", "'Constants:'", "'Patterns:'", "'Inputs:'", "'Outputs:'", "'State:'", "'Macros:'", "':'", "'Assumptions'", "'Environment'", "'DerivedRequirements'", "'Requirements'", "'Low-Level Requirements'", "'LLRs'", "'Implementation'", "'Design'", "'Constraints'", "'Properties'", "'Guarantees'", "'High-level Requirements'", "'HLRs'", "'import'", "'Definitions'", "'pattern'", "'('", "','", "')'", "'returns'", "'var'", "'let'", "'tel'", "'|'", "'='", "'--%PROPERTY'", "'assert'", "'*'", "'/'", "'record'", "'{'", "'}'", "'['", "']'", "'enum'", "'int'", "'bool'", "'real'", "'is a'", "'is an'", "'text'", "'while'", "'then'", "'=>'", "'implies'", "'or'", "'xor'", "'and'", "'after'", "'until'", "'T'", "'triggers'", "'S'", "'since'", "'O'", "'once'", "'H'", "'historically'", "'never'", "'before'", "'initially'", "'<'", "'less'", "'than'", "'<='", "'equal'", "'to'", "'>'", "'greater'", "'>='", "'=='", "'<>'", "'not'", "'+'", "'-'", "'mod'", "'->'", "'arrow'", "'previous'", "'with'", "'initial'", "'value'", "'.'", "':='", "'if'", "'else'", "'new'", "'spec'", "'#'", "'TRUE'", "'true'", "'FALSE'", "'false'"
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
    public static final int RULE_ML_COMMENT=7;
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
    public static final int T__11=11;
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
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==36) ) {
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
            otherlv_0=(Token)match(input,11,FOLLOW_3); if (state.failed) return current;
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

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSpear.g:142:4: otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )*
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSpecificationAccess().getImportsKeyword_2_0());
                          
                    }
                    // InternalSpear.g:146:1: ( (lv_imports_3_0= ruleImport ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==35) ) {
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

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSpear.g:164:7: otherlv_4= 'Units:' ( (lv_units_5_0= ruleUnitDef ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
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

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSpear.g:186:7: otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
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

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSpear.g:208:7: otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
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

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSpear.g:230:7: otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )*
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSpecificationAccess().getPatternsKeyword_6_0());
                          
                    }
                    // InternalSpear.g:234:1: ( (lv_patterns_11_0= rulePattern ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==37) ) {
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

            otherlv_12=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
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

            otherlv_14=(Token)match(input,18,FOLLOW_11); if (state.failed) return current;
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

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSpear.g:296:5: otherlv_16= 'State:' ( (lv_state_17_0= ruleVariable ) )*
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
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

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSpear.g:318:7: otherlv_18= 'Macros:' ( (lv_macros_19_0= ruleMacro ) )*
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
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

            if ( ((LA19_0>=22 && LA19_0<=23)) ) {
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

                    otherlv_21=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
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

            otherlv_24=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
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

            if ( (LA22_0==25||(LA22_0>=31 && LA22_0<=34)) ) {
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

                    otherlv_27=(Token)match(input,21,FOLLOW_14); if (state.failed) return current;
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

            if ( (LA23_0==22) ) {
                alt23=1;
            }
            else if ( (LA23_0==23) ) {
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
                    kw=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAssumptionsHeaderAccess().getAssumptionsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:489:2: kw= 'Environment'
                    {
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:511:1: ruleRequirementsHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Low-Level Requirements' | kw= 'LLRs' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' ) ;
    public final AntlrDatatypeRuleToken ruleRequirementsHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:514:28: ( (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Low-Level Requirements' | kw= 'LLRs' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' ) )
            // InternalSpear.g:515:1: (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Low-Level Requirements' | kw= 'LLRs' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' )
            {
            // InternalSpear.g:515:1: (kw= 'DerivedRequirements' | kw= 'Requirements' | kw= 'Low-Level Requirements' | kw= 'LLRs' | kw= 'Implementation' | kw= 'Design' | kw= 'Constraints' )
            int alt24=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt24=1;
                }
                break;
            case 25:
                {
                alt24=2;
                }
                break;
            case 26:
                {
                alt24=3;
                }
                break;
            case 27:
                {
                alt24=4;
                }
                break;
            case 28:
                {
                alt24=5;
                }
                break;
            case 29:
                {
                alt24=6;
                }
                break;
            case 30:
                {
                alt24=7;
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
                    kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getDerivedRequirementsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:523:2: kw= 'Requirements'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getRequirementsKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:530:2: kw= 'Low-Level Requirements'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getLowLevelRequirementsKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:537:2: kw= 'LLRs'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getLLRsKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpear.g:544:2: kw= 'Implementation'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getImplementationKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpear.g:551:2: kw= 'Design'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getDesignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalSpear.g:558:2: kw= 'Constraints'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRequirementsHeaderAccess().getConstraintsKeyword_6()); 
                          
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
    // InternalSpear.g:571:1: entryRulePropertiesHeader returns [String current=null] : iv_rulePropertiesHeader= rulePropertiesHeader EOF ;
    public final String entryRulePropertiesHeader() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertiesHeader = null;


        try {
            // InternalSpear.g:572:2: (iv_rulePropertiesHeader= rulePropertiesHeader EOF )
            // InternalSpear.g:573:2: iv_rulePropertiesHeader= rulePropertiesHeader EOF
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
    // InternalSpear.g:580:1: rulePropertiesHeader returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'High-level Requirements' | kw= 'HLRs' ) ;
    public final AntlrDatatypeRuleToken rulePropertiesHeader() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:583:28: ( (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'High-level Requirements' | kw= 'HLRs' ) )
            // InternalSpear.g:584:1: (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'High-level Requirements' | kw= 'HLRs' )
            {
            // InternalSpear.g:584:1: (kw= 'Requirements' | kw= 'Properties' | kw= 'Guarantees' | kw= 'High-level Requirements' | kw= 'HLRs' )
            int alt25=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt25=1;
                }
                break;
            case 31:
                {
                alt25=2;
                }
                break;
            case 32:
                {
                alt25=3;
                }
                break;
            case 33:
                {
                alt25=4;
                }
                break;
            case 34:
                {
                alt25=5;
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
                    // InternalSpear.g:585:2: kw= 'Requirements'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getRequirementsKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:592:2: kw= 'Properties'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getPropertiesKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:599:2: kw= 'Guarantees'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getGuaranteesKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:606:2: kw= 'High-level Requirements'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getHighLevelRequirementsKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalSpear.g:613:2: kw= 'HLRs'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPropertiesHeaderAccess().getHLRsKeyword_4()); 
                          
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
    // InternalSpear.g:626:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSpear.g:627:2: (iv_ruleImport= ruleImport EOF )
            // InternalSpear.g:628:2: iv_ruleImport= ruleImport EOF
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
    // InternalSpear.g:635:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:638:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalSpear.g:639:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalSpear.g:639:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalSpear.g:639:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // InternalSpear.g:643:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalSpear.g:644:1: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalSpear.g:644:1: (lv_importURI_1_0= RULE_STRING )
            // InternalSpear.g:645:3: lv_importURI_1_0= RULE_STRING
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
    // InternalSpear.g:669:1: entryRuleDefinitions returns [EObject current=null] : iv_ruleDefinitions= ruleDefinitions EOF ;
    public final EObject entryRuleDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitions = null;


        try {
            // InternalSpear.g:670:2: (iv_ruleDefinitions= ruleDefinitions EOF )
            // InternalSpear.g:671:2: iv_ruleDefinitions= ruleDefinitions EOF
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
    // InternalSpear.g:678:1: ruleDefinitions returns [EObject current=null] : (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? ) ;
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
            // InternalSpear.g:681:28: ( (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? ) )
            // InternalSpear.g:682:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? )
            {
            // InternalSpear.g:682:1: (otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )? )
            // InternalSpear.g:682:3: otherlv_0= 'Definitions' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )? (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )? (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )? (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )? (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefinitionsAccess().getDefinitionsKeyword_0());
                  
            }
            // InternalSpear.g:686:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpear.g:687:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSpear.g:687:1: (lv_name_1_0= RULE_ID )
            // InternalSpear.g:688:3: lv_name_1_0= RULE_ID
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

            // InternalSpear.g:704:2: (otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==12) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSpear.g:704:4: otherlv_2= 'Imports:' ( (lv_imports_3_0= ruleImport ) )*
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefinitionsAccess().getImportsKeyword_2_0());
                          
                    }
                    // InternalSpear.g:708:1: ( (lv_imports_3_0= ruleImport ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==35) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalSpear.g:709:1: (lv_imports_3_0= ruleImport )
                    	    {
                    	    // InternalSpear.g:709:1: (lv_imports_3_0= ruleImport )
                    	    // InternalSpear.g:710:3: lv_imports_3_0= ruleImport
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

            // InternalSpear.g:726:5: (otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==13) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSpear.g:726:7: otherlv_4= 'Units:' ( (lv_unitdefs_5_0= ruleUnitDef ) )*
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDefinitionsAccess().getUnitsKeyword_3_0());
                          
                    }
                    // InternalSpear.g:730:1: ( (lv_unitdefs_5_0= ruleUnitDef ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalSpear.g:731:1: (lv_unitdefs_5_0= ruleUnitDef )
                    	    {
                    	    // InternalSpear.g:731:1: (lv_unitdefs_5_0= ruleUnitDef )
                    	    // InternalSpear.g:732:3: lv_unitdefs_5_0= ruleUnitDef
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

            // InternalSpear.g:748:5: (otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==14) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSpear.g:748:7: otherlv_6= 'Types:' ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDefinitionsAccess().getTypesKeyword_4_0());
                          
                    }
                    // InternalSpear.g:752:1: ( (lv_typedefs_7_0= ruleTypeDef ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalSpear.g:753:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    {
                    	    // InternalSpear.g:753:1: (lv_typedefs_7_0= ruleTypeDef )
                    	    // InternalSpear.g:754:3: lv_typedefs_7_0= ruleTypeDef
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

            // InternalSpear.g:770:5: (otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==15) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalSpear.g:770:7: otherlv_8= 'Constants:' ( (lv_constants_9_0= ruleConstant ) )*
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDefinitionsAccess().getConstantsKeyword_5_0());
                          
                    }
                    // InternalSpear.g:774:1: ( (lv_constants_9_0= ruleConstant ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalSpear.g:775:1: (lv_constants_9_0= ruleConstant )
                    	    {
                    	    // InternalSpear.g:775:1: (lv_constants_9_0= ruleConstant )
                    	    // InternalSpear.g:776:3: lv_constants_9_0= ruleConstant
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

            // InternalSpear.g:792:5: (otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalSpear.g:792:7: otherlv_10= 'Patterns:' ( (lv_patterns_11_0= rulePattern ) )*
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getDefinitionsAccess().getPatternsKeyword_6_0());
                          
                    }
                    // InternalSpear.g:796:1: ( (lv_patterns_11_0= rulePattern ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==37) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalSpear.g:797:1: (lv_patterns_11_0= rulePattern )
                    	    {
                    	    // InternalSpear.g:797:1: (lv_patterns_11_0= rulePattern )
                    	    // InternalSpear.g:798:3: lv_patterns_11_0= rulePattern
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
    // InternalSpear.g:822:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalSpear.g:823:2: (iv_rulePattern= rulePattern EOF )
            // InternalSpear.g:824:2: iv_rulePattern= rulePattern EOF
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
    // InternalSpear.g:831:1: rulePattern returns [EObject current=null] : (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ) ;
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


         enterRule(); 
            
        try {
            // InternalSpear.g:834:28: ( (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' ) )
            // InternalSpear.g:835:1: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' )
            {
            // InternalSpear.g:835:1: (otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel' )
            // InternalSpear.g:835:3: otherlv_0= 'pattern' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )? otherlv_6= ')' otherlv_7= 'returns' otherlv_8= '(' ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )? otherlv_12= ')' (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )? otherlv_15= 'let' ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )* otherlv_19= 'tel'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
                  
            }
            // InternalSpear.g:839:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSpear.g:840:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSpear.g:840:1: (lv_name_1_0= RULE_ID )
            // InternalSpear.g:841:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,38,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalSpear.g:861:1: ( ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSpear.g:861:2: ( (lv_inputs_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )*
                    {
                    // InternalSpear.g:861:2: ( (lv_inputs_3_0= ruleVariable ) )
                    // InternalSpear.g:862:1: (lv_inputs_3_0= ruleVariable )
                    {
                    // InternalSpear.g:862:1: (lv_inputs_3_0= ruleVariable )
                    // InternalSpear.g:863:3: lv_inputs_3_0= ruleVariable
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

                    // InternalSpear.g:879:2: (otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==39) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalSpear.g:879:4: otherlv_4= ',' ( (lv_inputs_5_0= ruleVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getPatternAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalSpear.g:883:1: ( (lv_inputs_5_0= ruleVariable ) )
                    	    // InternalSpear.g:884:1: (lv_inputs_5_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:884:1: (lv_inputs_5_0= ruleVariable )
                    	    // InternalSpear.g:885:3: lv_inputs_5_0= ruleVariable
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

            otherlv_6=(Token)match(input,40,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getPatternAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_7=(Token)match(input,41,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getPatternAccess().getReturnsKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,38,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getPatternAccess().getLeftParenthesisKeyword_6());
                  
            }
            // InternalSpear.g:913:1: ( ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalSpear.g:913:2: ( (lv_outputs_9_0= ruleVariable ) ) (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )*
                    {
                    // InternalSpear.g:913:2: ( (lv_outputs_9_0= ruleVariable ) )
                    // InternalSpear.g:914:1: (lv_outputs_9_0= ruleVariable )
                    {
                    // InternalSpear.g:914:1: (lv_outputs_9_0= ruleVariable )
                    // InternalSpear.g:915:3: lv_outputs_9_0= ruleVariable
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

                    // InternalSpear.g:931:2: (otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==39) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalSpear.g:931:4: otherlv_10= ',' ( (lv_outputs_11_0= ruleVariable ) )
                    	    {
                    	    otherlv_10=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getPatternAccess().getCommaKeyword_7_1_0());
                    	          
                    	    }
                    	    // InternalSpear.g:935:1: ( (lv_outputs_11_0= ruleVariable ) )
                    	    // InternalSpear.g:936:1: (lv_outputs_11_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:936:1: (lv_outputs_11_0= ruleVariable )
                    	    // InternalSpear.g:937:3: lv_outputs_11_0= ruleVariable
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

            otherlv_12=(Token)match(input,40,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getPatternAccess().getRightParenthesisKeyword_8());
                  
            }
            // InternalSpear.g:957:1: (otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==42) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSpear.g:957:3: otherlv_13= 'var' ( (lv_locals_14_0= ruleVariable ) )*
                    {
                    otherlv_13=(Token)match(input,42,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getPatternAccess().getVarKeyword_9_0());
                          
                    }
                    // InternalSpear.g:961:1: ( (lv_locals_14_0= ruleVariable ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalSpear.g:962:1: (lv_locals_14_0= ruleVariable )
                    	    {
                    	    // InternalSpear.g:962:1: (lv_locals_14_0= ruleVariable )
                    	    // InternalSpear.g:963:3: lv_locals_14_0= ruleVariable
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

            otherlv_15=(Token)match(input,43,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getPatternAccess().getLetKeyword_10());
                  
            }
            // InternalSpear.g:983:1: ( ( (lv_equations_16_0= ruleLustreEquation ) ) | ( (lv_properties_17_0= ruleLustreProperty ) ) | ( (lv_assertions_18_0= ruleLustreAssertion ) ) )*
            loop42:
            do {
                int alt42=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                case 45:
                    {
                    alt42=1;
                    }
                    break;
                case 47:
                    {
                    alt42=2;
                    }
                    break;
                case 48:
                    {
                    alt42=3;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // InternalSpear.g:983:2: ( (lv_equations_16_0= ruleLustreEquation ) )
            	    {
            	    // InternalSpear.g:983:2: ( (lv_equations_16_0= ruleLustreEquation ) )
            	    // InternalSpear.g:984:1: (lv_equations_16_0= ruleLustreEquation )
            	    {
            	    // InternalSpear.g:984:1: (lv_equations_16_0= ruleLustreEquation )
            	    // InternalSpear.g:985:3: lv_equations_16_0= ruleLustreEquation
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
            	    // InternalSpear.g:1002:6: ( (lv_properties_17_0= ruleLustreProperty ) )
            	    {
            	    // InternalSpear.g:1002:6: ( (lv_properties_17_0= ruleLustreProperty ) )
            	    // InternalSpear.g:1003:1: (lv_properties_17_0= ruleLustreProperty )
            	    {
            	    // InternalSpear.g:1003:1: (lv_properties_17_0= ruleLustreProperty )
            	    // InternalSpear.g:1004:3: lv_properties_17_0= ruleLustreProperty
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
            	    // InternalSpear.g:1021:6: ( (lv_assertions_18_0= ruleLustreAssertion ) )
            	    {
            	    // InternalSpear.g:1021:6: ( (lv_assertions_18_0= ruleLustreAssertion ) )
            	    // InternalSpear.g:1022:1: (lv_assertions_18_0= ruleLustreAssertion )
            	    {
            	    // InternalSpear.g:1022:1: (lv_assertions_18_0= ruleLustreAssertion )
            	    // InternalSpear.g:1023:3: lv_assertions_18_0= ruleLustreAssertion
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

            otherlv_19=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_19, grammarAccess.getPatternAccess().getTelKeyword_12());
                  
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
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleLustreEquation"
    // InternalSpear.g:1051:1: entryRuleLustreEquation returns [EObject current=null] : iv_ruleLustreEquation= ruleLustreEquation EOF ;
    public final EObject entryRuleLustreEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreEquation = null;


        try {
            // InternalSpear.g:1052:2: (iv_ruleLustreEquation= ruleLustreEquation EOF )
            // InternalSpear.g:1053:2: iv_ruleLustreEquation= ruleLustreEquation EOF
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
    // InternalSpear.g:1060:1: ruleLustreEquation returns [EObject current=null] : ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) ) ;
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
            // InternalSpear.g:1063:28: ( ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) ) )
            // InternalSpear.g:1064:1: ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) )
            {
            // InternalSpear.g:1064:1: ( (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) ) | ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==45) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_ID) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalSpear.g:1064:2: (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:1064:2: (otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) ) )
                    // InternalSpear.g:1064:4: otherlv_0= '|' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' otherlv_5= '=' ( (lv_rhs_6_0= ruleExpr ) )
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLustreEquationAccess().getVerticalLineKeyword_0_0());
                          
                    }
                    // InternalSpear.g:1068:1: ( (otherlv_1= RULE_ID ) )
                    // InternalSpear.g:1069:1: (otherlv_1= RULE_ID )
                    {
                    // InternalSpear.g:1069:1: (otherlv_1= RULE_ID )
                    // InternalSpear.g:1070:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }

                    // InternalSpear.g:1081:2: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==39) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalSpear.g:1081:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getLustreEquationAccess().getCommaKeyword_0_2_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1085:1: ( (otherlv_3= RULE_ID ) )
                    	    // InternalSpear.g:1086:1: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalSpear.g:1086:1: (otherlv_3= RULE_ID )
                    	    // InternalSpear.g:1087:3: otherlv_3= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_3, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_0_2_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,45,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLustreEquationAccess().getVerticalLineKeyword_0_3());
                          
                    }
                    otherlv_5=(Token)match(input,46,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getLustreEquationAccess().getEqualsSignKeyword_0_4());
                          
                    }
                    // InternalSpear.g:1106:1: ( (lv_rhs_6_0= ruleExpr ) )
                    // InternalSpear.g:1107:1: (lv_rhs_6_0= ruleExpr )
                    {
                    // InternalSpear.g:1107:1: (lv_rhs_6_0= ruleExpr )
                    // InternalSpear.g:1108:3: lv_rhs_6_0= ruleExpr
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
                    // InternalSpear.g:1125:6: ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:1125:6: ( ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) ) )
                    // InternalSpear.g:1125:7: ( (otherlv_7= RULE_ID ) ) otherlv_8= '=' ( (lv_rhs_9_0= ruleExpr ) )
                    {
                    // InternalSpear.g:1125:7: ( (otherlv_7= RULE_ID ) )
                    // InternalSpear.g:1126:1: (otherlv_7= RULE_ID )
                    {
                    // InternalSpear.g:1126:1: (otherlv_7= RULE_ID )
                    // InternalSpear.g:1127:3: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getLustreEquationRule());
                      	        }
                              
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_7, grammarAccess.getLustreEquationAccess().getIdsVariableCrossReference_1_0_0()); 
                      	
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,46,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getLustreEquationAccess().getEqualsSignKeyword_1_1());
                          
                    }
                    // InternalSpear.g:1142:1: ( (lv_rhs_9_0= ruleExpr ) )
                    // InternalSpear.g:1143:1: (lv_rhs_9_0= ruleExpr )
                    {
                    // InternalSpear.g:1143:1: (lv_rhs_9_0= ruleExpr )
                    // InternalSpear.g:1144:3: lv_rhs_9_0= ruleExpr
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
    // InternalSpear.g:1168:1: entryRuleLustreProperty returns [EObject current=null] : iv_ruleLustreProperty= ruleLustreProperty EOF ;
    public final EObject entryRuleLustreProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreProperty = null;


        try {
            // InternalSpear.g:1169:2: (iv_ruleLustreProperty= ruleLustreProperty EOF )
            // InternalSpear.g:1170:2: iv_ruleLustreProperty= ruleLustreProperty EOF
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
    // InternalSpear.g:1177:1: ruleLustreProperty returns [EObject current=null] : (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleLustreProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:1180:28: ( (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSpear.g:1181:1: (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSpear.g:1181:1: (otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) ) )
            // InternalSpear.g:1181:3: otherlv_0= '--%PROPERTY' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLustrePropertyAccess().getPROPERTYKeyword_0());
                  
            }
            // InternalSpear.g:1185:1: ( (otherlv_1= RULE_ID ) )
            // InternalSpear.g:1186:1: (otherlv_1= RULE_ID )
            {
            // InternalSpear.g:1186:1: (otherlv_1= RULE_ID )
            // InternalSpear.g:1187:3: otherlv_1= RULE_ID
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
    // InternalSpear.g:1206:1: entryRuleLustreAssertion returns [EObject current=null] : iv_ruleLustreAssertion= ruleLustreAssertion EOF ;
    public final EObject entryRuleLustreAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLustreAssertion = null;


        try {
            // InternalSpear.g:1207:2: (iv_ruleLustreAssertion= ruleLustreAssertion EOF )
            // InternalSpear.g:1208:2: iv_ruleLustreAssertion= ruleLustreAssertion EOF
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
    // InternalSpear.g:1215:1: ruleLustreAssertion returns [EObject current=null] : (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) ) ;
    public final EObject ruleLustreAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_assertionExpr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1218:28: ( (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) ) )
            // InternalSpear.g:1219:1: (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) )
            {
            // InternalSpear.g:1219:1: (otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) ) )
            // InternalSpear.g:1219:3: otherlv_0= 'assert' ( (lv_assertionExpr_1_0= ruleExpr ) )
            {
            otherlv_0=(Token)match(input,48,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLustreAssertionAccess().getAssertKeyword_0());
                  
            }
            // InternalSpear.g:1223:1: ( (lv_assertionExpr_1_0= ruleExpr ) )
            // InternalSpear.g:1224:1: (lv_assertionExpr_1_0= ruleExpr )
            {
            // InternalSpear.g:1224:1: (lv_assertionExpr_1_0= ruleExpr )
            // InternalSpear.g:1225:3: lv_assertionExpr_1_0= ruleExpr
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
    // InternalSpear.g:1249:1: entryRuleUnitDef returns [EObject current=null] : iv_ruleUnitDef= ruleUnitDef EOF ;
    public final EObject entryRuleUnitDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitDef = null;


        try {
            // InternalSpear.g:1250:2: (iv_ruleUnitDef= ruleUnitDef EOF )
            // InternalSpear.g:1251:2: iv_ruleUnitDef= ruleUnitDef EOF
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
    // InternalSpear.g:1258:1: ruleUnitDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) ;
    public final EObject ruleUnitDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_description_2_0=null;
        Token lv_name_4_0=null;
        Token lv_description_7_0=null;
        EObject lv_unit_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1261:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) ) )
            // InternalSpear.g:1262:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            {
            // InternalSpear.g:1262:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? ) | ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==EOF||(LA47_1>=RULE_ID && LA47_1<=RULE_STRING)||(LA47_1>=14 && LA47_1<=17)) ) {
                    alt47=1;
                }
                else if ( (LA47_1==21||(LA47_1>=60 && LA47_1<=61)) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalSpear.g:1262:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    {
                    // InternalSpear.g:1262:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )? )
                    // InternalSpear.g:1262:3: () ( (lv_name_1_0= RULE_ID ) ) ( (lv_description_2_0= RULE_STRING ) )?
                    {
                    // InternalSpear.g:1262:3: ()
                    // InternalSpear.g:1263:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getBaseUnitAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1268:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpear.g:1269:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpear.g:1269:1: (lv_name_1_0= RULE_ID )
                    // InternalSpear.g:1270:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
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

                    // InternalSpear.g:1286:2: ( (lv_description_2_0= RULE_STRING ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==RULE_STRING) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalSpear.g:1287:1: (lv_description_2_0= RULE_STRING )
                            {
                            // InternalSpear.g:1287:1: (lv_description_2_0= RULE_STRING )
                            // InternalSpear.g:1288:3: lv_description_2_0= RULE_STRING
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
                    // InternalSpear.g:1305:6: ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    {
                    // InternalSpear.g:1305:6: ( () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )? )
                    // InternalSpear.g:1305:7: () ( (lv_name_4_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_unit_6_0= ruleUnitExpr ) ) ( (lv_description_7_0= RULE_STRING ) )?
                    {
                    // InternalSpear.g:1305:7: ()
                    // InternalSpear.g:1306:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUnitDefAccess().getDerivedUnitAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1311:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalSpear.g:1312:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalSpear.g:1312:1: (lv_name_4_0= RULE_ID )
                    // InternalSpear.g:1313:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
                    pushFollow(FOLLOW_34);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1337:1: ( (lv_unit_6_0= ruleUnitExpr ) )
                    // InternalSpear.g:1338:1: (lv_unit_6_0= ruleUnitExpr )
                    {
                    // InternalSpear.g:1338:1: (lv_unit_6_0= ruleUnitExpr )
                    // InternalSpear.g:1339:3: lv_unit_6_0= ruleUnitExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnitDefAccess().getUnitUnitExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_32);
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

                    // InternalSpear.g:1355:2: ( (lv_description_7_0= RULE_STRING ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_STRING) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalSpear.g:1356:1: (lv_description_7_0= RULE_STRING )
                            {
                            // InternalSpear.g:1356:1: (lv_description_7_0= RULE_STRING )
                            // InternalSpear.g:1357:3: lv_description_7_0= RULE_STRING
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
    // InternalSpear.g:1381:1: entryRuleUnitExpr returns [EObject current=null] : iv_ruleUnitExpr= ruleUnitExpr EOF ;
    public final EObject entryRuleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpr = null;


        try {
            // InternalSpear.g:1382:2: (iv_ruleUnitExpr= ruleUnitExpr EOF )
            // InternalSpear.g:1383:2: iv_ruleUnitExpr= ruleUnitExpr EOF
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
    // InternalSpear.g:1390:1: ruleUnitExpr returns [EObject current=null] : this_ProductUnitExpr_0= ruleProductUnitExpr ;
    public final EObject ruleUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ProductUnitExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1393:28: (this_ProductUnitExpr_0= ruleProductUnitExpr )
            // InternalSpear.g:1395:5: this_ProductUnitExpr_0= ruleProductUnitExpr
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
    // InternalSpear.g:1411:1: entryRuleProductUnitExpr returns [EObject current=null] : iv_ruleProductUnitExpr= ruleProductUnitExpr EOF ;
    public final EObject entryRuleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductUnitExpr = null;


        try {
            // InternalSpear.g:1412:2: (iv_ruleProductUnitExpr= ruleProductUnitExpr EOF )
            // InternalSpear.g:1413:2: iv_ruleProductUnitExpr= ruleProductUnitExpr EOF
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
    // InternalSpear.g:1420:1: ruleProductUnitExpr returns [EObject current=null] : (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) ;
    public final EObject ruleProductUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_DivisionUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1423:28: ( (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? ) )
            // InternalSpear.g:1424:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            {
            // InternalSpear.g:1424:1: (this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )? )
            // InternalSpear.g:1425:5: this_DivisionUnitExpr_0= ruleDivisionUnitExpr ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getProductUnitExprAccess().getDivisionUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_35);
            this_DivisionUnitExpr_0=ruleDivisionUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_DivisionUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:1433:1: ( ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==49) && (synpred1_InternalSpear())) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSpear.g:1433:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) ) ( (lv_right_3_0= ruleProductUnitExpr ) )
                    {
                    // InternalSpear.g:1433:2: ( ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) ) )
                    // InternalSpear.g:1433:3: ( ( () ( ( '*' ) ) ) )=> ( () ( (lv_op_2_0= '*' ) ) )
                    {
                    // InternalSpear.g:1440:6: ( () ( (lv_op_2_0= '*' ) ) )
                    // InternalSpear.g:1440:7: () ( (lv_op_2_0= '*' ) )
                    {
                    // InternalSpear.g:1440:7: ()
                    // InternalSpear.g:1441:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getProductUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1446:2: ( (lv_op_2_0= '*' ) )
                    // InternalSpear.g:1447:1: (lv_op_2_0= '*' )
                    {
                    // InternalSpear.g:1447:1: (lv_op_2_0= '*' )
                    // InternalSpear.g:1448:3: lv_op_2_0= '*'
                    {
                    lv_op_2_0=(Token)match(input,49,FOLLOW_34); if (state.failed) return current;
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

                    // InternalSpear.g:1461:4: ( (lv_right_3_0= ruleProductUnitExpr ) )
                    // InternalSpear.g:1462:1: (lv_right_3_0= ruleProductUnitExpr )
                    {
                    // InternalSpear.g:1462:1: (lv_right_3_0= ruleProductUnitExpr )
                    // InternalSpear.g:1463:3: lv_right_3_0= ruleProductUnitExpr
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
    // InternalSpear.g:1487:1: entryRuleDivisionUnitExpr returns [EObject current=null] : iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF ;
    public final EObject entryRuleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDivisionUnitExpr = null;


        try {
            // InternalSpear.g:1488:2: (iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF )
            // InternalSpear.g:1489:2: iv_ruleDivisionUnitExpr= ruleDivisionUnitExpr EOF
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
    // InternalSpear.g:1496:1: ruleDivisionUnitExpr returns [EObject current=null] : (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) ;
    public final EObject ruleDivisionUnitExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AtomicUnitExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1499:28: ( (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? ) )
            // InternalSpear.g:1500:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            {
            // InternalSpear.g:1500:1: (this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )? )
            // InternalSpear.g:1501:5: this_AtomicUnitExpr_0= ruleAtomicUnitExpr ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDivisionUnitExprAccess().getAtomicUnitExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_36);
            this_AtomicUnitExpr_0=ruleAtomicUnitExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicUnitExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:1509:1: ( ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==50) && (synpred2_InternalSpear())) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalSpear.g:1509:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) ) ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    {
                    // InternalSpear.g:1509:2: ( ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) ) )
                    // InternalSpear.g:1509:3: ( ( () ( ( '/' ) ) ) )=> ( () ( (lv_op_2_0= '/' ) ) )
                    {
                    // InternalSpear.g:1516:6: ( () ( (lv_op_2_0= '/' ) ) )
                    // InternalSpear.g:1516:7: () ( (lv_op_2_0= '/' ) )
                    {
                    // InternalSpear.g:1516:7: ()
                    // InternalSpear.g:1517:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getDivisionUnitExprAccess().getBinaryUnitExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1522:2: ( (lv_op_2_0= '/' ) )
                    // InternalSpear.g:1523:1: (lv_op_2_0= '/' )
                    {
                    // InternalSpear.g:1523:1: (lv_op_2_0= '/' )
                    // InternalSpear.g:1524:3: lv_op_2_0= '/'
                    {
                    lv_op_2_0=(Token)match(input,50,FOLLOW_34); if (state.failed) return current;
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

                    // InternalSpear.g:1537:4: ( (lv_right_3_0= ruleAtomicUnitExpr ) )
                    // InternalSpear.g:1538:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    {
                    // InternalSpear.g:1538:1: (lv_right_3_0= ruleAtomicUnitExpr )
                    // InternalSpear.g:1539:3: lv_right_3_0= ruleAtomicUnitExpr
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
    // InternalSpear.g:1563:1: entryRuleAtomicUnitExpr returns [EObject current=null] : iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF ;
    public final EObject entryRuleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicUnitExpr = null;


        try {
            // InternalSpear.g:1564:2: (iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF )
            // InternalSpear.g:1565:2: iv_ruleAtomicUnitExpr= ruleAtomicUnitExpr EOF
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
    // InternalSpear.g:1572:1: ruleAtomicUnitExpr returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) ;
    public final EObject ruleAtomicUnitExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_UnitExpr_3 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1575:28: ( ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) ) )
            // InternalSpear.g:1576:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            {
            // InternalSpear.g:1576:1: ( ( () ( (otherlv_1= RULE_ID ) ) ) | (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            else if ( (LA50_0==38) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalSpear.g:1576:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    {
                    // InternalSpear.g:1576:2: ( () ( (otherlv_1= RULE_ID ) ) )
                    // InternalSpear.g:1576:3: () ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalSpear.g:1576:3: ()
                    // InternalSpear.g:1577:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicUnitExprAccess().getNamedUnitExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1582:2: ( (otherlv_1= RULE_ID ) )
                    // InternalSpear.g:1583:1: (otherlv_1= RULE_ID )
                    {
                    // InternalSpear.g:1583:1: (otherlv_1= RULE_ID )
                    // InternalSpear.g:1584:3: otherlv_1= RULE_ID
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
                    // InternalSpear.g:1596:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    {
                    // InternalSpear.g:1596:6: (otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')' )
                    // InternalSpear.g:1596:8: otherlv_2= '(' this_UnitExpr_3= ruleUnitExpr otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAtomicUnitExprAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicUnitExprAccess().getUnitExprParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_37);
                    this_UnitExpr_3=ruleUnitExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnitExpr_3; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_4=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:1621:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalSpear.g:1622:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalSpear.g:1623:2: iv_ruleTypeDef= ruleTypeDef EOF
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
    // InternalSpear.g:1630:1: ruleTypeDef returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_name_15_0=null;
        Token otherlv_18=null;
        Token lv_size_19_0=null;
        Token otherlv_20=null;
        Token lv_name_22_0=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        EObject lv_type_3_0 = null;

        EObject lv_fields_10_0 = null;

        EObject lv_fields_12_0 = null;

        EObject lv_base_17_0 = null;

        EObject lv_values_26_0 = null;

        EObject lv_values_28_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1633:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) ) )
            // InternalSpear.g:1634:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )
            {
            // InternalSpear.g:1634:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )
            int alt54=4;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalSpear.g:1634:2: ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    {
                    // InternalSpear.g:1634:2: ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? )
                    // InternalSpear.g:1634:3: () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )?
                    {
                    // InternalSpear.g:1634:3: ()
                    // InternalSpear.g:1635:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getNamedTypeDefAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1640:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSpear.g:1641:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSpear.g:1641:1: (lv_name_1_0= RULE_ID )
                    // InternalSpear.g:1642:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
                    pushFollow(FOLLOW_38);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1666:1: ( (lv_type_3_0= ruleType ) )
                    // InternalSpear.g:1667:1: (lv_type_3_0= ruleType )
                    {
                    // InternalSpear.g:1667:1: (lv_type_3_0= ruleType )
                    // InternalSpear.g:1668:3: lv_type_3_0= ruleType
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

                    // InternalSpear.g:1684:2: ( (otherlv_4= RULE_ID ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_ID) ) {
                        int LA51_1 = input.LA(2);

                        if ( (LA51_1==EOF||LA51_1==RULE_ID||(LA51_1>=15 && LA51_1<=17)) ) {
                            alt51=1;
                        }
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalSpear.g:1685:1: (otherlv_4= RULE_ID )
                            {
                            // InternalSpear.g:1685:1: (otherlv_4= RULE_ID )
                            // InternalSpear.g:1686:3: otherlv_4= RULE_ID
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
                    // InternalSpear.g:1698:6: ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' )
                    {
                    // InternalSpear.g:1698:6: ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' )
                    // InternalSpear.g:1698:7: () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}'
                    {
                    // InternalSpear.g:1698:7: ()
                    // InternalSpear.g:1699:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getRecordTypeDefAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1704:2: ( (lv_name_6_0= RULE_ID ) )
                    // InternalSpear.g:1705:1: (lv_name_6_0= RULE_ID )
                    {
                    // InternalSpear.g:1705:1: (lv_name_6_0= RULE_ID )
                    // InternalSpear.g:1706:3: lv_name_6_0= RULE_ID
                    {
                    lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
                    pushFollow(FOLLOW_39);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_8=(Token)match(input,51,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTypeDefAccess().getRecordKeyword_1_3());
                          
                    }
                    otherlv_9=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_1_4());
                          
                    }
                    // InternalSpear.g:1738:1: ( (lv_fields_10_0= ruleFieldType ) )
                    // InternalSpear.g:1739:1: (lv_fields_10_0= ruleFieldType )
                    {
                    // InternalSpear.g:1739:1: (lv_fields_10_0= ruleFieldType )
                    // InternalSpear.g:1740:3: lv_fields_10_0= ruleFieldType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsFieldTypeParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
                    lv_fields_10_0=ruleFieldType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_10_0, 
                              		"com.rockwellcollins.Spear.FieldType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1756:2: (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==39) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalSpear.g:1756:4: otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) )
                    	    {
                    	    otherlv_11=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getTypeDefAccess().getCommaKeyword_1_6_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1760:1: ( (lv_fields_12_0= ruleFieldType ) )
                    	    // InternalSpear.g:1761:1: (lv_fields_12_0= ruleFieldType )
                    	    {
                    	    // InternalSpear.g:1761:1: (lv_fields_12_0= ruleFieldType )
                    	    // InternalSpear.g:1762:3: lv_fields_12_0= ruleFieldType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getFieldsFieldTypeParserRuleCall_1_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_41);
                    	    lv_fields_12_0=ruleFieldType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_12_0, 
                    	              		"com.rockwellcollins.Spear.FieldType");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_1_7());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:1783:6: ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' )
                    {
                    // InternalSpear.g:1783:6: ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' )
                    // InternalSpear.g:1783:7: () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']'
                    {
                    // InternalSpear.g:1783:7: ()
                    // InternalSpear.g:1784:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getArrayTypeDefAction_2_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1789:2: ( (lv_name_15_0= RULE_ID ) )
                    // InternalSpear.g:1790:1: (lv_name_15_0= RULE_ID )
                    {
                    // InternalSpear.g:1790:1: (lv_name_15_0= RULE_ID )
                    // InternalSpear.g:1791:3: lv_name_15_0= RULE_ID
                    {
                    lv_name_15_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_15_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_15_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_2_2()); 
                          
                    }
                    pushFollow(FOLLOW_38);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalSpear.g:1815:1: ( (lv_base_17_0= ruleType ) )
                    // InternalSpear.g:1816:1: (lv_base_17_0= ruleType )
                    {
                    // InternalSpear.g:1816:1: (lv_base_17_0= ruleType )
                    // InternalSpear.g:1817:3: lv_base_17_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getBaseTypeParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_42);
                    lv_base_17_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		set(
                             			current, 
                             			"base",
                              		lv_base_17_0, 
                              		"com.rockwellcollins.Spear.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_18=(Token)match(input,54,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTypeDefAccess().getLeftSquareBracketKeyword_2_4());
                          
                    }
                    // InternalSpear.g:1837:1: ( (lv_size_19_0= RULE_INT ) )
                    // InternalSpear.g:1838:1: (lv_size_19_0= RULE_INT )
                    {
                    // InternalSpear.g:1838:1: (lv_size_19_0= RULE_INT )
                    // InternalSpear.g:1839:3: lv_size_19_0= RULE_INT
                    {
                    lv_size_19_0=(Token)match(input,RULE_INT,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_size_19_0, grammarAccess.getTypeDefAccess().getSizeINTTerminalRuleCall_2_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"size",
                              		lv_size_19_0, 
                              		"org.eclipse.xtext.common.Terminals.INT");
                      	    
                    }

                    }


                    }

                    otherlv_20=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTypeDefAccess().getRightSquareBracketKeyword_2_6());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:1860:6: ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' )
                    {
                    // InternalSpear.g:1860:6: ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' )
                    // InternalSpear.g:1860:7: () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}'
                    {
                    // InternalSpear.g:1860:7: ()
                    // InternalSpear.g:1861:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeDefAccess().getEnumTypeDefAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:1866:2: ( (lv_name_22_0= RULE_ID ) )
                    // InternalSpear.g:1867:1: (lv_name_22_0= RULE_ID )
                    {
                    // InternalSpear.g:1867:1: (lv_name_22_0= RULE_ID )
                    // InternalSpear.g:1868:3: lv_name_22_0= RULE_ID
                    {
                    lv_name_22_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_22_0, grammarAccess.getTypeDefAccess().getNameIDTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeDefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_22_0, 
                              		"org.eclipse.xtext.common.Terminals.ID");
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeDefAccess().getIdTypeDelimiterParserRuleCall_3_2()); 
                          
                    }
                    pushFollow(FOLLOW_45);
                    ruleIdTypeDelimiter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_24=(Token)match(input,56,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getTypeDefAccess().getEnumKeyword_3_3());
                          
                    }
                    otherlv_25=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getTypeDefAccess().getLeftCurlyBracketKeyword_3_4());
                          
                    }
                    // InternalSpear.g:1900:1: ( (lv_values_26_0= ruleEnumValue ) )
                    // InternalSpear.g:1901:1: (lv_values_26_0= ruleEnumValue )
                    {
                    // InternalSpear.g:1901:1: (lv_values_26_0= ruleEnumValue )
                    // InternalSpear.g:1902:3: lv_values_26_0= ruleEnumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
                    lv_values_26_0=ruleEnumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                      	        }
                             		add(
                             			current, 
                             			"values",
                              		lv_values_26_0, 
                              		"com.rockwellcollins.Spear.EnumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalSpear.g:1918:2: (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==39) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalSpear.g:1918:4: otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) )
                    	    {
                    	    otherlv_27=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_27, grammarAccess.getTypeDefAccess().getCommaKeyword_3_6_0());
                    	          
                    	    }
                    	    // InternalSpear.g:1922:1: ( (lv_values_28_0= ruleEnumValue ) )
                    	    // InternalSpear.g:1923:1: (lv_values_28_0= ruleEnumValue )
                    	    {
                    	    // InternalSpear.g:1923:1: (lv_values_28_0= ruleEnumValue )
                    	    // InternalSpear.g:1924:3: lv_values_28_0= ruleEnumValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeDefAccess().getValuesEnumValueParserRuleCall_3_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_41);
                    	    lv_values_28_0=ruleEnumValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"values",
                    	              		lv_values_28_0, 
                    	              		"com.rockwellcollins.Spear.EnumValue");
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

                    otherlv_29=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getTypeDefAccess().getRightCurlyBracketKeyword_3_7());
                          
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
    // InternalSpear.g:1952:1: entryRuleFieldType returns [EObject current=null] : iv_ruleFieldType= ruleFieldType EOF ;
    public final EObject entryRuleFieldType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldType = null;


        try {
            // InternalSpear.g:1953:2: (iv_ruleFieldType= ruleFieldType EOF )
            // InternalSpear.g:1954:2: iv_ruleFieldType= ruleFieldType EOF
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
    // InternalSpear.g:1961:1: ruleFieldType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleFieldType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:1964:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) ) )
            // InternalSpear.g:1965:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalSpear.g:1965:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) ) )
            // InternalSpear.g:1965:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleType ) )
            {
            // InternalSpear.g:1965:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:1966:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:1966:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:1967:3: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,21,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldTypeAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:1987:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:1988:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:1988:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:1989:3: lv_type_2_0= ruleType
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
    // InternalSpear.g:2013:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalSpear.g:2014:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalSpear.g:2015:2: iv_ruleEnumValue= ruleEnumValue EOF
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
    // InternalSpear.g:2022:1: ruleEnumValue returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2025:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSpear.g:2026:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSpear.g:2026:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2027:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2027:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2028:3: lv_name_0_0= RULE_ID
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
    // InternalSpear.g:2052:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSpear.g:2053:2: (iv_ruleType= ruleType EOF )
            // InternalSpear.g:2054:2: iv_ruleType= ruleType EOF
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
    // InternalSpear.g:2061:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2064:28: ( ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalSpear.g:2065:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalSpear.g:2065:1: ( ( () otherlv_1= 'int' ) | ( () otherlv_3= 'bool' ) | ( () otherlv_5= 'real' ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt55=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt55=1;
                }
                break;
            case 58:
                {
                alt55=2;
                }
                break;
            case 59:
                {
                alt55=3;
                }
                break;
            case RULE_ID:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalSpear.g:2065:2: ( () otherlv_1= 'int' )
                    {
                    // InternalSpear.g:2065:2: ( () otherlv_1= 'int' )
                    // InternalSpear.g:2065:3: () otherlv_1= 'int'
                    {
                    // InternalSpear.g:2065:3: ()
                    // InternalSpear.g:2066:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getIntTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getIntKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSpear.g:2076:6: ( () otherlv_3= 'bool' )
                    {
                    // InternalSpear.g:2076:6: ( () otherlv_3= 'bool' )
                    // InternalSpear.g:2076:7: () otherlv_3= 'bool'
                    {
                    // InternalSpear.g:2076:7: ()
                    // InternalSpear.g:2077:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getBoolTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getBoolKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:2087:6: ( () otherlv_5= 'real' )
                    {
                    // InternalSpear.g:2087:6: ( () otherlv_5= 'real' )
                    // InternalSpear.g:2087:7: () otherlv_5= 'real'
                    {
                    // InternalSpear.g:2087:7: ()
                    // InternalSpear.g:2088:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getRealTypeAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getRealKeyword_2_1());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:2098:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSpear.g:2098:6: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalSpear.g:2098:7: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalSpear.g:2098:7: ()
                    // InternalSpear.g:2099:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getUserTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2104:2: ( (otherlv_7= RULE_ID ) )
                    // InternalSpear.g:2105:1: (otherlv_7= RULE_ID )
                    {
                    // InternalSpear.g:2105:1: (otherlv_7= RULE_ID )
                    // InternalSpear.g:2106:3: otherlv_7= RULE_ID
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
    // InternalSpear.g:2125:1: entryRuleIdTypeDelimiter returns [String current=null] : iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF ;
    public final String entryRuleIdTypeDelimiter() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdTypeDelimiter = null;


        try {
            // InternalSpear.g:2126:2: (iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF )
            // InternalSpear.g:2127:2: iv_ruleIdTypeDelimiter= ruleIdTypeDelimiter EOF
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
    // InternalSpear.g:2134:1: ruleIdTypeDelimiter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ':' | kw= 'is a' | kw= 'is an' ) ;
    public final AntlrDatatypeRuleToken ruleIdTypeDelimiter() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2137:28: ( (kw= ':' | kw= 'is a' | kw= 'is an' ) )
            // InternalSpear.g:2138:1: (kw= ':' | kw= 'is a' | kw= 'is an' )
            {
            // InternalSpear.g:2138:1: (kw= ':' | kw= 'is a' | kw= 'is an' )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt56=1;
                }
                break;
            case 60:
                {
                alt56=2;
                }
                break;
            case 61:
                {
                alt56=3;
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
                    // InternalSpear.g:2139:2: kw= ':'
                    {
                    kw=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdTypeDelimiterAccess().getColonKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:2146:2: kw= 'is a'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdTypeDelimiterAccess().getIsAKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalSpear.g:2153:2: kw= 'is an'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:2166:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSpear.g:2167:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalSpear.g:2168:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalSpear.g:2175:1: ruleConstant returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_descriptor_7_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2178:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? ) )
            // InternalSpear.g:2179:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? )
            {
            // InternalSpear.g:2179:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? )
            // InternalSpear.g:2179:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )?
            {
            // InternalSpear.g:2179:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2180:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2180:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2181:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
            pushFollow(FOLLOW_38);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2205:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2206:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2206:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2207:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,46,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getConstantAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalSpear.g:2227:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalSpear.g:2228:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalSpear.g:2228:1: (lv_expr_4_0= ruleExpr )
            // InternalSpear.g:2229:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
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

            // InternalSpear.g:2245:2: (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==62) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalSpear.g:2245:4: otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,62,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getConstantAccess().getTextKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getConstantAccess().getEqualsSignKeyword_5_1());
                          
                    }
                    // InternalSpear.g:2253:1: ( (lv_descriptor_7_0= RULE_STRING ) )
                    // InternalSpear.g:2254:1: (lv_descriptor_7_0= RULE_STRING )
                    {
                    // InternalSpear.g:2254:1: (lv_descriptor_7_0= RULE_STRING )
                    // InternalSpear.g:2255:3: lv_descriptor_7_0= RULE_STRING
                    {
                    lv_descriptor_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_descriptor_7_0, grammarAccess.getConstantAccess().getDescriptorSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstantRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"descriptor",
                              		lv_descriptor_7_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // InternalSpear.g:2279:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSpear.g:2280:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalSpear.g:2281:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalSpear.g:2288:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2291:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) ) )
            // InternalSpear.g:2292:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalSpear.g:2292:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) )
            // InternalSpear.g:2292:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) )
            {
            // InternalSpear.g:2292:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2293:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2293:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2294:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
            pushFollow(FOLLOW_38);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2318:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2319:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2319:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2320:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
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
    // InternalSpear.g:2344:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // InternalSpear.g:2345:2: (iv_ruleMacro= ruleMacro EOF )
            // InternalSpear.g:2346:2: iv_ruleMacro= ruleMacro EOF
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
    // InternalSpear.g:2353:1: ruleMacro returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_descriptor_7_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2356:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? ) )
            // InternalSpear.g:2357:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? )
            {
            // InternalSpear.g:2357:1: ( ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )? )
            // InternalSpear.g:2357:2: ( (lv_name_0_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_2_0= ruleType ) ) otherlv_3= '=' ( (lv_expr_4_0= ruleExpr ) ) (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )?
            {
            // InternalSpear.g:2357:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2358:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2358:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2359:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
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
            pushFollow(FOLLOW_38);
            ruleIdTypeDelimiter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2383:1: ( (lv_type_2_0= ruleType ) )
            // InternalSpear.g:2384:1: (lv_type_2_0= ruleType )
            {
            // InternalSpear.g:2384:1: (lv_type_2_0= ruleType )
            // InternalSpear.g:2385:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,46,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalSpear.g:2405:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalSpear.g:2406:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalSpear.g:2406:1: (lv_expr_4_0= ruleExpr )
            // InternalSpear.g:2407:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
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

            // InternalSpear.g:2423:2: (otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==62) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalSpear.g:2423:4: otherlv_5= 'text' otherlv_6= '=' ( (lv_descriptor_7_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,62,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getTextKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getMacroAccess().getEqualsSignKeyword_5_1());
                          
                    }
                    // InternalSpear.g:2431:1: ( (lv_descriptor_7_0= RULE_STRING ) )
                    // InternalSpear.g:2432:1: (lv_descriptor_7_0= RULE_STRING )
                    {
                    // InternalSpear.g:2432:1: (lv_descriptor_7_0= RULE_STRING )
                    // InternalSpear.g:2433:3: lv_descriptor_7_0= RULE_STRING
                    {
                    lv_descriptor_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_descriptor_7_0, grammarAccess.getMacroAccess().getDescriptorSTRINGTerminalRuleCall_5_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMacroRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"descriptor",
                              		lv_descriptor_7_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
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
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleConstraint"
    // InternalSpear.g:2457:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalSpear.g:2458:2: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalSpear.g:2459:2: iv_ruleConstraint= ruleConstraint EOF
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
    // InternalSpear.g:2466:1: ruleConstraint returns [EObject current=null] : (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_FormalConstraint_0 = null;

        EObject this_EnglishConstraint_1 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2469:28: ( (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint ) )
            // InternalSpear.g:2470:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            {
            // InternalSpear.g:2470:1: (this_FormalConstraint_0= ruleFormalConstraint | this_EnglishConstraint_1= ruleEnglishConstraint )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==21) ) {
                    int LA59_2 = input.LA(3);

                    if ( (LA59_2==RULE_ID||LA59_2==RULE_INT||LA59_2==38||LA59_2==45||LA59_2==63||LA59_2==70||(LA59_2>=76 && LA59_2<=82)||LA59_2==94||LA59_2==96||LA59_2==100||LA59_2==106||(LA59_2>=108 && LA59_2<=114)) ) {
                        alt59=1;
                    }
                    else if ( (LA59_2==RULE_STRING) ) {
                        alt59=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalSpear.g:2471:5: this_FormalConstraint_0= ruleFormalConstraint
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
                    // InternalSpear.g:2481:5: this_EnglishConstraint_1= ruleEnglishConstraint
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
    // InternalSpear.g:2497:1: entryRuleFormalConstraint returns [EObject current=null] : iv_ruleFormalConstraint= ruleFormalConstraint EOF ;
    public final EObject entryRuleFormalConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormalConstraint = null;


        try {
            // InternalSpear.g:2498:2: (iv_ruleFormalConstraint= ruleFormalConstraint EOF )
            // InternalSpear.g:2499:2: iv_ruleFormalConstraint= ruleFormalConstraint EOF
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
    // InternalSpear.g:2506:1: ruleFormalConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFormalConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_descriptor_5_0=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2509:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )? ) )
            // InternalSpear.g:2510:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )? )
            {
            // InternalSpear.g:2510:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )? )
            // InternalSpear.g:2510:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleExpr ) ) (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )?
            {
            // InternalSpear.g:2510:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2511:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2511:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2512:3: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,21,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFormalConstraintAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:2532:1: ( (lv_expr_2_0= ruleExpr ) )
            // InternalSpear.g:2533:1: (lv_expr_2_0= ruleExpr )
            {
            // InternalSpear.g:2533:1: (lv_expr_2_0= ruleExpr )
            // InternalSpear.g:2534:3: lv_expr_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFormalConstraintAccess().getExprExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
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

            // InternalSpear.g:2550:2: (otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==62) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalSpear.g:2550:4: otherlv_3= 'text' otherlv_4= '=' ( (lv_descriptor_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,62,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFormalConstraintAccess().getTextKeyword_3_0());
                          
                    }
                    otherlv_4=(Token)match(input,46,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFormalConstraintAccess().getEqualsSignKeyword_3_1());
                          
                    }
                    // InternalSpear.g:2558:1: ( (lv_descriptor_5_0= RULE_STRING ) )
                    // InternalSpear.g:2559:1: (lv_descriptor_5_0= RULE_STRING )
                    {
                    // InternalSpear.g:2559:1: (lv_descriptor_5_0= RULE_STRING )
                    // InternalSpear.g:2560:3: lv_descriptor_5_0= RULE_STRING
                    {
                    lv_descriptor_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_descriptor_5_0, grammarAccess.getFormalConstraintAccess().getDescriptorSTRINGTerminalRuleCall_3_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFormalConstraintRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"descriptor",
                              		lv_descriptor_5_0, 
                              		"org.eclipse.xtext.common.Terminals.STRING");
                      	    
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
    // $ANTLR end "ruleFormalConstraint"


    // $ANTLR start "entryRuleEnglishConstraint"
    // InternalSpear.g:2584:1: entryRuleEnglishConstraint returns [EObject current=null] : iv_ruleEnglishConstraint= ruleEnglishConstraint EOF ;
    public final EObject entryRuleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnglishConstraint = null;


        try {
            // InternalSpear.g:2585:2: (iv_ruleEnglishConstraint= ruleEnglishConstraint EOF )
            // InternalSpear.g:2586:2: iv_ruleEnglishConstraint= ruleEnglishConstraint EOF
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
    // InternalSpear.g:2593:1: ruleEnglishConstraint returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleEnglishConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_text_2_0=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:2596:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) ) )
            // InternalSpear.g:2597:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) )
            {
            // InternalSpear.g:2597:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) ) )
            // InternalSpear.g:2597:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_text_2_0= RULE_STRING ) )
            {
            // InternalSpear.g:2597:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSpear.g:2598:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSpear.g:2598:1: (lv_name_0_0= RULE_ID )
            // InternalSpear.g:2599:3: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,21,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnglishConstraintAccess().getColonKeyword_1());
                  
            }
            // InternalSpear.g:2619:1: ( (lv_text_2_0= RULE_STRING ) )
            // InternalSpear.g:2620:1: (lv_text_2_0= RULE_STRING )
            {
            // InternalSpear.g:2620:1: (lv_text_2_0= RULE_STRING )
            // InternalSpear.g:2621:3: lv_text_2_0= RULE_STRING
            {
            lv_text_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleExpr"
    // InternalSpear.g:2645:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalSpear.g:2646:2: (iv_ruleExpr= ruleExpr EOF )
            // InternalSpear.g:2647:2: iv_ruleExpr= ruleExpr EOF
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
    // InternalSpear.g:2654:1: ruleExpr returns [EObject current=null] : this_WhileExpr_0= ruleWhileExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_WhileExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2657:28: (this_WhileExpr_0= ruleWhileExpr )
            // InternalSpear.g:2659:5: this_WhileExpr_0= ruleWhileExpr
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
    // InternalSpear.g:2675:1: entryRuleWhileExpr returns [EObject current=null] : iv_ruleWhileExpr= ruleWhileExpr EOF ;
    public final EObject entryRuleWhileExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileExpr = null;


        try {
            // InternalSpear.g:2676:2: (iv_ruleWhileExpr= ruleWhileExpr EOF )
            // InternalSpear.g:2677:2: iv_ruleWhileExpr= ruleWhileExpr EOF
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
    // InternalSpear.g:2684:1: ruleWhileExpr returns [EObject current=null] : ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr ) ;
    public final EObject ruleWhileExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject this_ImpliesExpr_5 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2687:28: ( ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr ) )
            // InternalSpear.g:2688:1: ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr )
            {
            // InternalSpear.g:2688:1: ( ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) ) | this_ImpliesExpr_5= ruleImpliesExpr )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==63) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID||LA61_0==RULE_INT||LA61_0==38||LA61_0==45||LA61_0==70||(LA61_0>=76 && LA61_0<=82)||LA61_0==94||LA61_0==96||LA61_0==100||LA61_0==106||(LA61_0>=108 && LA61_0<=114)) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalSpear.g:2688:2: ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) )
                    {
                    // InternalSpear.g:2688:2: ( () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) ) )
                    // InternalSpear.g:2688:3: () otherlv_1= 'while' ( (lv_cond_2_0= ruleExpr ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleExpr ) )
                    {
                    // InternalSpear.g:2688:3: ()
                    // InternalSpear.g:2689:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getWhileExprAccess().getWhileExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,63,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getWhileExprAccess().getWhileKeyword_0_1());
                          
                    }
                    // InternalSpear.g:2698:1: ( (lv_cond_2_0= ruleExpr ) )
                    // InternalSpear.g:2699:1: (lv_cond_2_0= ruleExpr )
                    {
                    // InternalSpear.g:2699:1: (lv_cond_2_0= ruleExpr )
                    // InternalSpear.g:2700:3: lv_cond_2_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWhileExprAccess().getCondExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_47);
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

                    otherlv_3=(Token)match(input,64,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getWhileExprAccess().getThenKeyword_0_3());
                          
                    }
                    // InternalSpear.g:2720:1: ( (lv_then_4_0= ruleExpr ) )
                    // InternalSpear.g:2721:1: (lv_then_4_0= ruleExpr )
                    {
                    // InternalSpear.g:2721:1: (lv_then_4_0= ruleExpr )
                    // InternalSpear.g:2722:3: lv_then_4_0= ruleExpr
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
                    // InternalSpear.g:2740:5: this_ImpliesExpr_5= ruleImpliesExpr
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
    // InternalSpear.g:2756:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalSpear.g:2757:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalSpear.g:2758:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
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
    // InternalSpear.g:2765:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2768:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalSpear.g:2769:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalSpear.g:2769:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalSpear.g:2770:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_48);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2778:1: ( ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==65) ) {
                int LA63_1 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt63=1;
                }
            }
            else if ( (LA63_0==66) ) {
                int LA63_2 = input.LA(2);

                if ( (synpred3_InternalSpear()) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalSpear.g:2778:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalSpear.g:2778:2: ( ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) ) )
                    // InternalSpear.g:2778:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    {
                    // InternalSpear.g:2791:6: ( () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) ) )
                    // InternalSpear.g:2791:7: () ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    {
                    // InternalSpear.g:2791:7: ()
                    // InternalSpear.g:2792:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2797:2: ( ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) ) )
                    // InternalSpear.g:2798:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    {
                    // InternalSpear.g:2798:1: ( (lv_op_2_1= '=>' | lv_op_2_2= 'implies' ) )
                    // InternalSpear.g:2799:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    {
                    // InternalSpear.g:2799:1: (lv_op_2_1= '=>' | lv_op_2_2= 'implies' )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==65) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==66) ) {
                        alt62=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalSpear.g:2800:3: lv_op_2_1= '=>'
                            {
                            lv_op_2_1=(Token)match(input,65,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:2812:8: lv_op_2_2= 'implies'
                            {
                            lv_op_2_2=(Token)match(input,66,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:2827:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalSpear.g:2828:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalSpear.g:2828:1: (lv_right_3_0= ruleImpliesExpr )
                    // InternalSpear.g:2829:3: lv_right_3_0= ruleImpliesExpr
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
    // InternalSpear.g:2853:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalSpear.g:2854:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalSpear.g:2855:2: iv_ruleOrExpr= ruleOrExpr EOF
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
    // InternalSpear.g:2862:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2865:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? ) )
            // InternalSpear.g:2866:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? )
            {
            // InternalSpear.g:2866:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )? )
            // InternalSpear.g:2867:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_49);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2875:1: ( ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==67) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt65=1;
                }
            }
            else if ( (LA65_0==68) ) {
                int LA65_2 = input.LA(2);

                if ( (synpred4_InternalSpear()) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalSpear.g:2875:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) ) ( (lv_right_3_0= ruleOrExpr ) )
                    {
                    // InternalSpear.g:2875:2: ( ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) ) )
                    // InternalSpear.g:2875:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    {
                    // InternalSpear.g:2888:6: ( () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) ) )
                    // InternalSpear.g:2888:7: () ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    {
                    // InternalSpear.g:2888:7: ()
                    // InternalSpear.g:2889:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2894:2: ( ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) ) )
                    // InternalSpear.g:2895:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    {
                    // InternalSpear.g:2895:1: ( (lv_op_2_1= 'or' | lv_op_2_2= 'xor' ) )
                    // InternalSpear.g:2896:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    {
                    // InternalSpear.g:2896:1: (lv_op_2_1= 'or' | lv_op_2_2= 'xor' )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==67) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==68) ) {
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
                            // InternalSpear.g:2897:3: lv_op_2_1= 'or'
                            {
                            lv_op_2_1=(Token)match(input,67,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:2909:8: lv_op_2_2= 'xor'
                            {
                            lv_op_2_2=(Token)match(input,68,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:2924:4: ( (lv_right_3_0= ruleOrExpr ) )
                    // InternalSpear.g:2925:1: (lv_right_3_0= ruleOrExpr )
                    {
                    // InternalSpear.g:2925:1: (lv_right_3_0= ruleOrExpr )
                    // InternalSpear.g:2926:3: lv_right_3_0= ruleOrExpr
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
    // InternalSpear.g:2950:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalSpear.g:2951:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalSpear.g:2952:2: iv_ruleAndExpr= ruleAndExpr EOF
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
    // InternalSpear.g:2959:1: ruleAndExpr returns [EObject current=null] : (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AfterUntilExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:2962:28: ( (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? ) )
            // InternalSpear.g:2963:1: (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            {
            // InternalSpear.g:2963:1: (this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )? )
            // InternalSpear.g:2964:5: this_AfterUntilExpr_0= ruleAfterUntilExpr ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getAfterUntilExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_50);
            this_AfterUntilExpr_0=ruleAfterUntilExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AfterUntilExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:2972:1: ( ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==69) ) {
                int LA66_1 = input.LA(2);

                if ( (synpred5_InternalSpear()) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalSpear.g:2972:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) ) ( (lv_right_3_0= ruleAndExpr ) )
                    {
                    // InternalSpear.g:2972:2: ( ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) ) )
                    // InternalSpear.g:2972:3: ( ( () ( ( 'and' ) ) ) )=> ( () ( (lv_op_2_0= 'and' ) ) )
                    {
                    // InternalSpear.g:2979:6: ( () ( (lv_op_2_0= 'and' ) ) )
                    // InternalSpear.g:2979:7: () ( (lv_op_2_0= 'and' ) )
                    {
                    // InternalSpear.g:2979:7: ()
                    // InternalSpear.g:2980:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:2985:2: ( (lv_op_2_0= 'and' ) )
                    // InternalSpear.g:2986:1: (lv_op_2_0= 'and' )
                    {
                    // InternalSpear.g:2986:1: (lv_op_2_0= 'and' )
                    // InternalSpear.g:2987:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)match(input,69,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3000:4: ( (lv_right_3_0= ruleAndExpr ) )
                    // InternalSpear.g:3001:1: (lv_right_3_0= ruleAndExpr )
                    {
                    // InternalSpear.g:3001:1: (lv_right_3_0= ruleAndExpr )
                    // InternalSpear.g:3002:3: lv_right_3_0= ruleAndExpr
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
    // InternalSpear.g:3026:1: entryRuleAfterUntilExpr returns [EObject current=null] : iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF ;
    public final EObject entryRuleAfterUntilExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAfterUntilExpr = null;


        try {
            // InternalSpear.g:3027:2: (iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF )
            // InternalSpear.g:3028:2: iv_ruleAfterUntilExpr= ruleAfterUntilExpr EOF
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
    // InternalSpear.g:3035:1: ruleAfterUntilExpr returns [EObject current=null] : ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr ) ;
    public final EObject ruleAfterUntilExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_after_2_0 = null;

        EObject lv_until_4_0 = null;

        EObject this_TriggersExpr_5 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3038:28: ( ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr ) )
            // InternalSpear.g:3039:1: ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr )
            {
            // InternalSpear.g:3039:1: ( ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? ) | this_TriggersExpr_5= ruleTriggersExpr )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==70) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_ID||LA68_0==RULE_INT||LA68_0==38||LA68_0==45||(LA68_0>=76 && LA68_0<=82)||LA68_0==94||LA68_0==96||LA68_0==100||LA68_0==106||(LA68_0>=108 && LA68_0<=114)) ) {
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
                    // InternalSpear.g:3039:2: ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? )
                    {
                    // InternalSpear.g:3039:2: ( () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )? )
                    // InternalSpear.g:3039:3: () otherlv_1= 'after' ( (lv_after_2_0= ruleTriggersExpr ) ) ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )?
                    {
                    // InternalSpear.g:3039:3: ()
                    // InternalSpear.g:3040:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAfterUntilExprAccess().getAfterUntilExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,70,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAfterUntilExprAccess().getAfterKeyword_0_1());
                          
                    }
                    // InternalSpear.g:3049:1: ( (lv_after_2_0= ruleTriggersExpr ) )
                    // InternalSpear.g:3050:1: (lv_after_2_0= ruleTriggersExpr )
                    {
                    // InternalSpear.g:3050:1: (lv_after_2_0= ruleTriggersExpr )
                    // InternalSpear.g:3051:3: lv_after_2_0= ruleTriggersExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAfterUntilExprAccess().getAfterTriggersExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
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

                    // InternalSpear.g:3067:2: ( ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==71) ) {
                        int LA67_1 = input.LA(2);

                        if ( (synpred6_InternalSpear()) ) {
                            alt67=1;
                        }
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalSpear.g:3067:3: ( ( 'until' )=>otherlv_3= 'until' ) ( (lv_until_4_0= ruleTriggersExpr ) )
                            {
                            // InternalSpear.g:3067:3: ( ( 'until' )=>otherlv_3= 'until' )
                            // InternalSpear.g:3067:4: ( 'until' )=>otherlv_3= 'until'
                            {
                            otherlv_3=(Token)match(input,71,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getAfterUntilExprAccess().getUntilKeyword_0_3_0());
                                  
                            }

                            }

                            // InternalSpear.g:3072:2: ( (lv_until_4_0= ruleTriggersExpr ) )
                            // InternalSpear.g:3073:1: (lv_until_4_0= ruleTriggersExpr )
                            {
                            // InternalSpear.g:3073:1: (lv_until_4_0= ruleTriggersExpr )
                            // InternalSpear.g:3074:3: lv_until_4_0= ruleTriggersExpr
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
                    // InternalSpear.g:3092:5: this_TriggersExpr_5= ruleTriggersExpr
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
    // InternalSpear.g:3108:1: entryRuleTriggersExpr returns [EObject current=null] : iv_ruleTriggersExpr= ruleTriggersExpr EOF ;
    public final EObject entryRuleTriggersExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggersExpr = null;


        try {
            // InternalSpear.g:3109:2: (iv_ruleTriggersExpr= ruleTriggersExpr EOF )
            // InternalSpear.g:3110:2: iv_ruleTriggersExpr= ruleTriggersExpr EOF
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
    // InternalSpear.g:3117:1: ruleTriggersExpr returns [EObject current=null] : (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) ;
    public final EObject ruleTriggersExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_SinceExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3120:28: ( (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? ) )
            // InternalSpear.g:3121:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            {
            // InternalSpear.g:3121:1: (this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )? )
            // InternalSpear.g:3122:5: this_SinceExpr_0= ruleSinceExpr ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTriggersExprAccess().getSinceExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_52);
            this_SinceExpr_0=ruleSinceExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SinceExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3130:1: ( ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==72) ) {
                int LA70_1 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt70=1;
                }
            }
            else if ( (LA70_0==73) ) {
                int LA70_2 = input.LA(2);

                if ( (synpred7_InternalSpear()) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalSpear.g:3130:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) ) ( (lv_right_3_0= ruleTriggersExpr ) )
                    {
                    // InternalSpear.g:3130:2: ( ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) ) )
                    // InternalSpear.g:3130:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    {
                    // InternalSpear.g:3143:6: ( () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) ) )
                    // InternalSpear.g:3143:7: () ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    {
                    // InternalSpear.g:3143:7: ()
                    // InternalSpear.g:3144:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getTriggersExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3149:2: ( ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) ) )
                    // InternalSpear.g:3150:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    {
                    // InternalSpear.g:3150:1: ( (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' ) )
                    // InternalSpear.g:3151:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    {
                    // InternalSpear.g:3151:1: (lv_op_2_1= 'T' | lv_op_2_2= 'triggers' )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==72) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==73) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalSpear.g:3152:3: lv_op_2_1= 'T'
                            {
                            lv_op_2_1=(Token)match(input,72,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3164:8: lv_op_2_2= 'triggers'
                            {
                            lv_op_2_2=(Token)match(input,73,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3179:4: ( (lv_right_3_0= ruleTriggersExpr ) )
                    // InternalSpear.g:3180:1: (lv_right_3_0= ruleTriggersExpr )
                    {
                    // InternalSpear.g:3180:1: (lv_right_3_0= ruleTriggersExpr )
                    // InternalSpear.g:3181:3: lv_right_3_0= ruleTriggersExpr
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
    // InternalSpear.g:3205:1: entryRuleSinceExpr returns [EObject current=null] : iv_ruleSinceExpr= ruleSinceExpr EOF ;
    public final EObject entryRuleSinceExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSinceExpr = null;


        try {
            // InternalSpear.g:3206:2: (iv_ruleSinceExpr= ruleSinceExpr EOF )
            // InternalSpear.g:3207:2: iv_ruleSinceExpr= ruleSinceExpr EOF
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
    // InternalSpear.g:3214:1: ruleSinceExpr returns [EObject current=null] : (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) ;
    public final EObject ruleSinceExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TemporalPrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3217:28: ( (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? ) )
            // InternalSpear.g:3218:1: (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            {
            // InternalSpear.g:3218:1: (this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )? )
            // InternalSpear.g:3219:5: this_TemporalPrefixExpr_0= ruleTemporalPrefixExpr ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSinceExprAccess().getTemporalPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_53);
            this_TemporalPrefixExpr_0=ruleTemporalPrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TemporalPrefixExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3227:1: ( ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==74) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred8_InternalSpear()) ) {
                    alt72=1;
                }
            }
            else if ( (LA72_0==75) ) {
                int LA72_2 = input.LA(2);

                if ( (synpred8_InternalSpear()) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalSpear.g:3227:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) ) ( (lv_right_3_0= ruleSinceExpr ) )
                    {
                    // InternalSpear.g:3227:2: ( ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) ) )
                    // InternalSpear.g:3227:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )=> ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    {
                    // InternalSpear.g:3240:6: ( () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) ) )
                    // InternalSpear.g:3240:7: () ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    {
                    // InternalSpear.g:3240:7: ()
                    // InternalSpear.g:3241:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getSinceExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3246:2: ( ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) ) )
                    // InternalSpear.g:3247:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    {
                    // InternalSpear.g:3247:1: ( (lv_op_2_1= 'S' | lv_op_2_2= 'since' ) )
                    // InternalSpear.g:3248:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    {
                    // InternalSpear.g:3248:1: (lv_op_2_1= 'S' | lv_op_2_2= 'since' )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==74) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==75) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalSpear.g:3249:3: lv_op_2_1= 'S'
                            {
                            lv_op_2_1=(Token)match(input,74,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3261:8: lv_op_2_2= 'since'
                            {
                            lv_op_2_2=(Token)match(input,75,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3276:4: ( (lv_right_3_0= ruleSinceExpr ) )
                    // InternalSpear.g:3277:1: (lv_right_3_0= ruleSinceExpr )
                    {
                    // InternalSpear.g:3277:1: (lv_right_3_0= ruleSinceExpr )
                    // InternalSpear.g:3278:3: lv_right_3_0= ruleSinceExpr
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
    // InternalSpear.g:3302:1: entryRuleTemporalPrefixExpr returns [EObject current=null] : iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF ;
    public final EObject entryRuleTemporalPrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalPrefixExpr = null;


        try {
            // InternalSpear.g:3303:2: (iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF )
            // InternalSpear.g:3304:2: iv_ruleTemporalPrefixExpr= ruleTemporalPrefixExpr EOF
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
    // InternalSpear.g:3311:1: ruleTemporalPrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr ) ;
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
            // InternalSpear.g:3314:28: ( ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr ) )
            // InternalSpear.g:3315:1: ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr )
            {
            // InternalSpear.g:3315:1: ( ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) ) | this_RelationalExpr_3= ruleRelationalExpr )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=76 && LA74_0<=82)) ) {
                alt74=1;
            }
            else if ( (LA74_0==RULE_ID||LA74_0==RULE_INT||LA74_0==38||LA74_0==45||LA74_0==94||LA74_0==96||LA74_0==100||LA74_0==106||(LA74_0>=108 && LA74_0<=114)) ) {
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
                    // InternalSpear.g:3315:2: ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) )
                    {
                    // InternalSpear.g:3315:2: ( () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) ) )
                    // InternalSpear.g:3315:3: () ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) ) ( (lv_expr_2_0= ruleTemporalPrefixExpr ) )
                    {
                    // InternalSpear.g:3315:3: ()
                    // InternalSpear.g:3316:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTemporalPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3321:2: ( ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) ) )
                    // InternalSpear.g:3322:1: ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) )
                    {
                    // InternalSpear.g:3322:1: ( (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' ) )
                    // InternalSpear.g:3323:1: (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' )
                    {
                    // InternalSpear.g:3323:1: (lv_op_1_1= 'O' | lv_op_1_2= 'once' | lv_op_1_3= 'H' | lv_op_1_4= 'historically' | lv_op_1_5= 'never' | lv_op_1_6= 'before' | lv_op_1_7= 'initially' )
                    int alt73=7;
                    switch ( input.LA(1) ) {
                    case 76:
                        {
                        alt73=1;
                        }
                        break;
                    case 77:
                        {
                        alt73=2;
                        }
                        break;
                    case 78:
                        {
                        alt73=3;
                        }
                        break;
                    case 79:
                        {
                        alt73=4;
                        }
                        break;
                    case 80:
                        {
                        alt73=5;
                        }
                        break;
                    case 81:
                        {
                        alt73=6;
                        }
                        break;
                    case 82:
                        {
                        alt73=7;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 0, input);

                        throw nvae;
                    }

                    switch (alt73) {
                        case 1 :
                            // InternalSpear.g:3324:3: lv_op_1_1= 'O'
                            {
                            lv_op_1_1=(Token)match(input,76,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3336:8: lv_op_1_2= 'once'
                            {
                            lv_op_1_2=(Token)match(input,77,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3348:8: lv_op_1_3= 'H'
                            {
                            lv_op_1_3=(Token)match(input,78,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3360:8: lv_op_1_4= 'historically'
                            {
                            lv_op_1_4=(Token)match(input,79,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3372:8: lv_op_1_5= 'never'
                            {
                            lv_op_1_5=(Token)match(input,80,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3384:8: lv_op_1_6= 'before'
                            {
                            lv_op_1_6=(Token)match(input,81,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3396:8: lv_op_1_7= 'initially'
                            {
                            lv_op_1_7=(Token)match(input,82,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3411:2: ( (lv_expr_2_0= ruleTemporalPrefixExpr ) )
                    // InternalSpear.g:3412:1: (lv_expr_2_0= ruleTemporalPrefixExpr )
                    {
                    // InternalSpear.g:3412:1: (lv_expr_2_0= ruleTemporalPrefixExpr )
                    // InternalSpear.g:3413:3: lv_expr_2_0= ruleTemporalPrefixExpr
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
                    // InternalSpear.g:3431:5: this_RelationalExpr_3= ruleRelationalExpr
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
    // InternalSpear.g:3447:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalSpear.g:3448:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalSpear.g:3449:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
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
    // InternalSpear.g:3456:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3459:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? ) )
            // InternalSpear.g:3460:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            {
            // InternalSpear.g:3460:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )? )
            // InternalSpear.g:3461:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExprAccess().getPlusExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_54);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PlusExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3469:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalSpear.g:3469:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) )
                    {
                    // InternalSpear.g:3469:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalSpear.g:3469:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalSpear.g:3474:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalSpear.g:3474:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalSpear.g:3474:7: ()
                    // InternalSpear.g:3475:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3480:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalSpear.g:3481:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalSpear.g:3481:1: (lv_op_2_0= ruleRelationalOp )
                    // InternalSpear.g:3482:3: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_31);
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

                    // InternalSpear.g:3498:4: ( (lv_right_3_0= ruleRelationalExpr ) )
                    // InternalSpear.g:3499:1: (lv_right_3_0= ruleRelationalExpr )
                    {
                    // InternalSpear.g:3499:1: (lv_right_3_0= ruleRelationalExpr )
                    // InternalSpear.g:3500:3: lv_right_3_0= ruleRelationalExpr
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
    // InternalSpear.g:3524:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalSpear.g:3525:2: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalSpear.g:3526:2: iv_ruleRelationalOp= ruleRelationalOp EOF
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
    // InternalSpear.g:3533:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:3536:28: ( (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) ) )
            // InternalSpear.g:3537:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )
            {
            // InternalSpear.g:3537:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )
            int alt76=12;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalSpear.g:3538:2: kw= '<'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:3544:6: (kw= 'less' kw= 'than' )
                    {
                    // InternalSpear.g:3544:6: (kw= 'less' kw= 'than' )
                    // InternalSpear.g:3545:2: kw= 'less' kw= 'than'
                    {
                    kw=(Token)match(input,84,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSpear.g:3558:2: kw= '<='
                    {
                    kw=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalSpear.g:3564:6: (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3564:6: (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3565:2: kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,84,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessKeyword_3_0()); 
                          
                    }
                    kw=(Token)match(input,85,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_3_1()); 
                          
                    }
                    kw=(Token)match(input,67,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getOrKeyword_3_2()); 
                          
                    }
                    kw=(Token)match(input,87,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_3_3()); 
                          
                    }
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_3_4()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSpear.g:3596:2: kw= '>'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalSpear.g:3602:6: (kw= 'greater' kw= 'than' )
                    {
                    // InternalSpear.g:3602:6: (kw= 'greater' kw= 'than' )
                    // InternalSpear.g:3603:2: kw= 'greater' kw= 'than'
                    {
                    kw=(Token)match(input,90,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterKeyword_5_0()); 
                          
                    }
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_5_1()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSpear.g:3616:2: kw= '>='
                    {
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalSpear.g:3622:6: (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3622:6: (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3623:2: kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,90,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterKeyword_7_0()); 
                          
                    }
                    kw=(Token)match(input,85,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getThanKeyword_7_1()); 
                          
                    }
                    kw=(Token)match(input,67,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getOrKeyword_7_2()); 
                          
                    }
                    kw=(Token)match(input,87,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_7_3()); 
                          
                    }
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_7_4()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSpear.g:3654:2: kw= '=='
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalSpear.g:3660:6: (kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3660:6: (kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3661:2: kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,87,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_9_0()); 
                          
                    }
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getToKeyword_9_1()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalSpear.g:3674:2: kw= '<>'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignGreaterThanSignKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalSpear.g:3680:6: (kw= 'not' kw= 'equal' kw= 'to' )
                    {
                    // InternalSpear.g:3680:6: (kw= 'not' kw= 'equal' kw= 'to' )
                    // InternalSpear.g:3681:2: kw= 'not' kw= 'equal' kw= 'to'
                    {
                    kw=(Token)match(input,94,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getNotKeyword_11_0()); 
                          
                    }
                    kw=(Token)match(input,87,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualKeyword_11_1()); 
                          
                    }
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:3706:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalSpear.g:3707:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalSpear.g:3708:2: iv_rulePlusExpr= rulePlusExpr EOF
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
    // InternalSpear.g:3715:1: rulePlusExpr returns [EObject current=null] : (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_MultiplyExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3718:28: ( (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalSpear.g:3719:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalSpear.g:3719:1: (this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalSpear.g:3720:5: this_MultiplyExpr_0= ruleMultiplyExpr ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPlusExprAccess().getMultiplyExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_59);
            this_MultiplyExpr_0=ruleMultiplyExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplyExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3728:1: ( ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==95) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt78=1;
                }
            }
            else if ( (LA78_0==96) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred10_InternalSpear()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // InternalSpear.g:3728:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalSpear.g:3728:2: ( ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) )
                    // InternalSpear.g:3728:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    {
                    // InternalSpear.g:3741:6: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
                    // InternalSpear.g:3741:7: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    {
                    // InternalSpear.g:3741:7: ()
                    // InternalSpear.g:3742:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3747:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // InternalSpear.g:3748:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // InternalSpear.g:3748:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // InternalSpear.g:3749:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // InternalSpear.g:3749:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==95) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==96) ) {
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
                            // InternalSpear.g:3750:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)match(input,95,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3762:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)match(input,96,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3777:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalSpear.g:3778:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalSpear.g:3778:1: (lv_right_3_0= rulePlusExpr )
                    // InternalSpear.g:3779:3: lv_right_3_0= rulePlusExpr
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
    // InternalSpear.g:3803:1: entryRuleMultiplyExpr returns [EObject current=null] : iv_ruleMultiplyExpr= ruleMultiplyExpr EOF ;
    public final EObject entryRuleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyExpr = null;


        try {
            // InternalSpear.g:3804:2: (iv_ruleMultiplyExpr= ruleMultiplyExpr EOF )
            // InternalSpear.g:3805:2: iv_ruleMultiplyExpr= ruleMultiplyExpr EOF
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
    // InternalSpear.g:3812:1: ruleMultiplyExpr returns [EObject current=null] : (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) ;
    public final EObject ruleMultiplyExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ArrowExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3815:28: ( (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? ) )
            // InternalSpear.g:3816:1: (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            {
            // InternalSpear.g:3816:1: (this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )? )
            // InternalSpear.g:3817:5: this_ArrowExpr_0= ruleArrowExpr ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplyExprAccess().getArrowExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_60);
            this_ArrowExpr_0=ruleArrowExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ArrowExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3825:1: ( ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) ) )?
            int alt80=2;
            switch ( input.LA(1) ) {
                case 49:
                    {
                    int LA80_1 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA80_2 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 97:
                    {
                    int LA80_3 = input.LA(2);

                    if ( (synpred11_InternalSpear()) ) {
                        alt80=1;
                    }
                    }
                    break;
            }

            switch (alt80) {
                case 1 :
                    // InternalSpear.g:3825:2: ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) ) ( (lv_right_3_0= ruleMultiplyExpr ) )
                    {
                    // InternalSpear.g:3825:2: ( ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) ) )
                    // InternalSpear.g:3825:3: ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) )
                    {
                    // InternalSpear.g:3841:6: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) ) )
                    // InternalSpear.g:3841:7: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) )
                    {
                    // InternalSpear.g:3841:7: ()
                    // InternalSpear.g:3842:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getMultiplyExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3847:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) ) )
                    // InternalSpear.g:3848:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) )
                    {
                    // InternalSpear.g:3848:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' ) )
                    // InternalSpear.g:3849:1: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' )
                    {
                    // InternalSpear.g:3849:1: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'mod' )
                    int alt79=3;
                    switch ( input.LA(1) ) {
                    case 49:
                        {
                        alt79=1;
                        }
                        break;
                    case 50:
                        {
                        alt79=2;
                        }
                        break;
                    case 97:
                        {
                        alt79=3;
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
                            // InternalSpear.g:3850:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)match(input,49,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3862:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)match(input,50,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3874:8: lv_op_2_3= 'mod'
                            {
                            lv_op_2_3=(Token)match(input,97,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3889:4: ( (lv_right_3_0= ruleMultiplyExpr ) )
                    // InternalSpear.g:3890:1: (lv_right_3_0= ruleMultiplyExpr )
                    {
                    // InternalSpear.g:3890:1: (lv_right_3_0= ruleMultiplyExpr )
                    // InternalSpear.g:3891:3: lv_right_3_0= ruleMultiplyExpr
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
    // InternalSpear.g:3915:1: entryRuleArrowExpr returns [EObject current=null] : iv_ruleArrowExpr= ruleArrowExpr EOF ;
    public final EObject entryRuleArrowExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrowExpr = null;


        try {
            // InternalSpear.g:3916:2: (iv_ruleArrowExpr= ruleArrowExpr EOF )
            // InternalSpear.g:3917:2: iv_ruleArrowExpr= ruleArrowExpr EOF
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
    // InternalSpear.g:3924:1: ruleArrowExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? ) ;
    public final EObject ruleArrowExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:3927:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? ) )
            // InternalSpear.g:3928:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? )
            {
            // InternalSpear.g:3928:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )? )
            // InternalSpear.g:3929:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getArrowExprAccess().getPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_61);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrefixExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:3937:1: ( ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==98) ) {
                int LA82_1 = input.LA(2);

                if ( (synpred12_InternalSpear()) ) {
                    alt82=1;
                }
            }
            else if ( (LA82_0==99) ) {
                int LA82_2 = input.LA(2);

                if ( (synpred12_InternalSpear()) ) {
                    alt82=1;
                }
            }
            switch (alt82) {
                case 1 :
                    // InternalSpear.g:3937:2: ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) ) ( (lv_right_3_0= ruleArrowExpr ) )
                    {
                    // InternalSpear.g:3937:2: ( ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) ) )
                    // InternalSpear.g:3937:3: ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )=> ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) )
                    {
                    // InternalSpear.g:3950:6: ( () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) ) )
                    // InternalSpear.g:3950:7: () ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) )
                    {
                    // InternalSpear.g:3950:7: ()
                    // InternalSpear.g:3951:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getArrowExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:3956:2: ( ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) ) )
                    // InternalSpear.g:3957:1: ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) )
                    {
                    // InternalSpear.g:3957:1: ( (lv_op_2_1= '->' | lv_op_2_2= 'arrow' ) )
                    // InternalSpear.g:3958:1: (lv_op_2_1= '->' | lv_op_2_2= 'arrow' )
                    {
                    // InternalSpear.g:3958:1: (lv_op_2_1= '->' | lv_op_2_2= 'arrow' )
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==98) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==99) ) {
                        alt81=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalSpear.g:3959:3: lv_op_2_1= '->'
                            {
                            lv_op_2_1=(Token)match(input,98,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:3971:8: lv_op_2_2= 'arrow'
                            {
                            lv_op_2_2=(Token)match(input,99,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:3986:4: ( (lv_right_3_0= ruleArrowExpr ) )
                    // InternalSpear.g:3987:1: (lv_right_3_0= ruleArrowExpr )
                    {
                    // InternalSpear.g:3987:1: (lv_right_3_0= ruleArrowExpr )
                    // InternalSpear.g:3988:3: lv_right_3_0= ruleArrowExpr
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
    // InternalSpear.g:4012:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalSpear.g:4013:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalSpear.g:4014:2: iv_rulePrefixExpr= rulePrefixExpr EOF
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
    // InternalSpear.g:4021:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr ) ;
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
            // InternalSpear.g:4024:28: ( ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr ) )
            // InternalSpear.g:4025:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr )
            {
            // InternalSpear.g:4025:1: ( ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? ) | this_AccessExpr_10= ruleAccessExpr )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 94:
            case 96:
                {
                alt85=1;
                }
                break;
            case 100:
                {
                alt85=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case 38:
            case 45:
            case 106:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
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
                    // InternalSpear.g:4025:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalSpear.g:4025:2: ( () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalSpear.g:4025:3: () ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalSpear.g:4025:3: ()
                    // InternalSpear.g:4026:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4031:2: ( ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) ) )
                    // InternalSpear.g:4032:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) )
                    {
                    // InternalSpear.g:4032:1: ( (lv_op_1_1= '-' | lv_op_1_2= 'not' ) )
                    // InternalSpear.g:4033:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' )
                    {
                    // InternalSpear.g:4033:1: (lv_op_1_1= '-' | lv_op_1_2= 'not' )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==96) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==94) ) {
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
                            // InternalSpear.g:4034:3: lv_op_1_1= '-'
                            {
                            lv_op_1_1=(Token)match(input,96,FOLLOW_31); if (state.failed) return current;
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
                            // InternalSpear.g:4046:8: lv_op_1_2= 'not'
                            {
                            lv_op_1_2=(Token)match(input,94,FOLLOW_31); if (state.failed) return current;
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

                    // InternalSpear.g:4061:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalSpear.g:4062:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalSpear.g:4062:1: (lv_expr_2_0= rulePrefixExpr )
                    // InternalSpear.g:4063:3: lv_expr_2_0= rulePrefixExpr
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
                    // InternalSpear.g:4080:6: ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? )
                    {
                    // InternalSpear.g:4080:6: ( () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )? )
                    // InternalSpear.g:4080:7: () otherlv_4= 'previous' ( (lv_var_5_0= rulePrefixExpr ) ) ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )?
                    {
                    // InternalSpear.g:4080:7: ()
                    // InternalSpear.g:4081:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getPreviousExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,100,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrefixExprAccess().getPreviousKeyword_1_1());
                          
                    }
                    // InternalSpear.g:4090:1: ( (lv_var_5_0= rulePrefixExpr ) )
                    // InternalSpear.g:4091:1: (lv_var_5_0= rulePrefixExpr )
                    {
                    // InternalSpear.g:4091:1: (lv_var_5_0= rulePrefixExpr )
                    // InternalSpear.g:4092:3: lv_var_5_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getVarPrefixExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_62);
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

                    // InternalSpear.g:4108:2: ( ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==101) ) {
                        int LA84_1 = input.LA(2);

                        if ( (synpred13_InternalSpear()) ) {
                            alt84=1;
                        }
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalSpear.g:4108:3: ( ( 'with' )=>otherlv_6= 'with' ) otherlv_7= 'initial' otherlv_8= 'value' ( (lv_init_9_0= rulePrefixExpr ) )
                            {
                            // InternalSpear.g:4108:3: ( ( 'with' )=>otherlv_6= 'with' )
                            // InternalSpear.g:4108:4: ( 'with' )=>otherlv_6= 'with'
                            {
                            otherlv_6=(Token)match(input,101,FOLLOW_63); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getPrefixExprAccess().getWithKeyword_1_3_0());
                                  
                            }

                            }

                            otherlv_7=(Token)match(input,102,FOLLOW_64); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getPrefixExprAccess().getInitialKeyword_1_3_1());
                                  
                            }
                            otherlv_8=(Token)match(input,103,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getPrefixExprAccess().getValueKeyword_1_3_2());
                                  
                            }
                            // InternalSpear.g:4121:1: ( (lv_init_9_0= rulePrefixExpr ) )
                            // InternalSpear.g:4122:1: (lv_init_9_0= rulePrefixExpr )
                            {
                            // InternalSpear.g:4122:1: (lv_init_9_0= rulePrefixExpr )
                            // InternalSpear.g:4123:3: lv_init_9_0= rulePrefixExpr
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
                    // InternalSpear.g:4141:5: this_AccessExpr_10= ruleAccessExpr
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
    // InternalSpear.g:4157:1: entryRuleAccessExpr returns [EObject current=null] : iv_ruleAccessExpr= ruleAccessExpr EOF ;
    public final EObject entryRuleAccessExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessExpr = null;


        try {
            // InternalSpear.g:4158:2: (iv_ruleAccessExpr= ruleAccessExpr EOF )
            // InternalSpear.g:4159:2: iv_ruleAccessExpr= ruleAccessExpr EOF
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
    // InternalSpear.g:4166:1: ruleAccessExpr returns [EObject current=null] : (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) ;
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
            // InternalSpear.g:4169:28: ( (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* ) )
            // InternalSpear.g:4170:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            {
            // InternalSpear.g:4170:1: (this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )* )
            // InternalSpear.g:4171:5: this_AtomicExpr_0= ruleAtomicExpr ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAccessExprAccess().getAtomicExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_65);
            this_AtomicExpr_0=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AtomicExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalSpear.g:4179:1: ( ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) ) | ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' ) | ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' ) )*
            loop87:
            do {
                int alt87=4;
                switch ( input.LA(1) ) {
                case 104:
                    {
                    int LA87_2 = input.LA(2);

                    if ( (synpred14_InternalSpear()) ) {
                        alt87=1;
                    }


                    }
                    break;
                case 52:
                    {
                    int LA87_3 = input.LA(2);

                    if ( (synpred15_InternalSpear()) ) {
                        alt87=2;
                    }


                    }
                    break;
                case 54:
                    {
                    int LA87_4 = input.LA(2);

                    if ( (synpred16_InternalSpear()) ) {
                        alt87=3;
                    }


                    }
                    break;

                }

                switch (alt87) {
            	case 1 :
            	    // InternalSpear.g:4179:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    {
            	    // InternalSpear.g:4179:2: ( ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) ) )
            	    // InternalSpear.g:4179:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) ) ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalSpear.g:4179:3: ( ( ( () '.' ) )=> ( () otherlv_2= '.' ) )
            	    // InternalSpear.g:4179:4: ( ( () '.' ) )=> ( () otherlv_2= '.' )
            	    {
            	    // InternalSpear.g:4181:5: ( () otherlv_2= '.' )
            	    // InternalSpear.g:4181:6: () otherlv_2= '.'
            	    {
            	    // InternalSpear.g:4181:6: ()
            	    // InternalSpear.g:4182:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordAccessExprRecordAction_1_0_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,104,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAccessExprAccess().getFullStopKeyword_1_0_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4191:3: ( (otherlv_3= RULE_ID ) )
            	    // InternalSpear.g:4192:1: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSpear.g:4192:1: (otherlv_3= RULE_ID )
            	    // InternalSpear.g:4193:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_65); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getAccessExprAccess().getFieldFieldTypeCrossReference_1_0_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSpear.g:4205:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    {
            	    // InternalSpear.g:4205:6: ( ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}' )
            	    // InternalSpear.g:4205:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) ) ( (lv_value_8_0= ruleExpr ) ) otherlv_9= '}'
            	    {
            	    // InternalSpear.g:4205:7: ( ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' ) )
            	    // InternalSpear.g:4205:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )=> ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    {
            	    // InternalSpear.g:4213:5: ( () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':=' )
            	    // InternalSpear.g:4213:6: () otherlv_5= '{' ( (otherlv_6= RULE_ID ) ) otherlv_7= ':='
            	    {
            	    // InternalSpear.g:4213:6: ()
            	    // InternalSpear.g:4214:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getRecordUpdateExprRecordAction_1_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_5=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getAccessExprAccess().getLeftCurlyBracketKeyword_1_1_0_0_1());
            	          
            	    }
            	    // InternalSpear.g:4223:1: ( (otherlv_6= RULE_ID ) )
            	    // InternalSpear.g:4224:1: (otherlv_6= RULE_ID )
            	    {
            	    // InternalSpear.g:4224:1: (otherlv_6= RULE_ID )
            	    // InternalSpear.g:4225:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessExprRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_66); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getAccessExprAccess().getFieldFieldTypeCrossReference_1_1_0_0_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    otherlv_7=(Token)match(input,105,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_1_0_0_3());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4240:3: ( (lv_value_8_0= ruleExpr ) )
            	    // InternalSpear.g:4241:1: (lv_value_8_0= ruleExpr )
            	    {
            	    // InternalSpear.g:4241:1: (lv_value_8_0= ruleExpr )
            	    // InternalSpear.g:4242:3: lv_value_8_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_67);
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

            	    otherlv_9=(Token)match(input,53,FOLLOW_65); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getAccessExprAccess().getRightCurlyBracketKeyword_1_1_2());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSpear.g:4263:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    {
            	    // InternalSpear.g:4263:6: ( ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']' )
            	    // InternalSpear.g:4263:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) ) ( (lv_index_12_0= ruleExpr ) ) ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )? otherlv_16= ']'
            	    {
            	    // InternalSpear.g:4263:7: ( ( ( () '[' ) )=> ( () otherlv_11= '[' ) )
            	    // InternalSpear.g:4263:8: ( ( () '[' ) )=> ( () otherlv_11= '[' )
            	    {
            	    // InternalSpear.g:4265:5: ( () otherlv_11= '[' )
            	    // InternalSpear.g:4265:6: () otherlv_11= '['
            	    {
            	    // InternalSpear.g:4265:6: ()
            	    // InternalSpear.g:4266:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAccessExprAccess().getArrayAccessExprArrayAction_1_2_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_11=(Token)match(input,54,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getAccessExprAccess().getLeftSquareBracketKeyword_1_2_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // InternalSpear.g:4275:3: ( (lv_index_12_0= ruleExpr ) )
            	    // InternalSpear.g:4276:1: (lv_index_12_0= ruleExpr )
            	    {
            	    // InternalSpear.g:4276:1: (lv_index_12_0= ruleExpr )
            	    // InternalSpear.g:4277:3: lv_index_12_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessExprAccess().getIndexExprParserRuleCall_1_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_68);
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

            	    // InternalSpear.g:4293:2: ( ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) ) )?
            	    int alt86=2;
            	    int LA86_0 = input.LA(1);

            	    if ( (LA86_0==105) && (synpred17_InternalSpear())) {
            	        alt86=1;
            	    }
            	    switch (alt86) {
            	        case 1 :
            	            // InternalSpear.g:4293:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) ) ( (lv_value_15_0= ruleExpr ) )
            	            {
            	            // InternalSpear.g:4293:3: ( ( ( () ':=' ) )=> ( () otherlv_14= ':=' ) )
            	            // InternalSpear.g:4293:4: ( ( () ':=' ) )=> ( () otherlv_14= ':=' )
            	            {
            	            // InternalSpear.g:4295:5: ( () otherlv_14= ':=' )
            	            // InternalSpear.g:4295:6: () otherlv_14= ':='
            	            {
            	            // InternalSpear.g:4295:6: ()
            	            // InternalSpear.g:4296:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAccessExprAccess().getArrayUpdateExprAccessAction_1_2_2_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_14=(Token)match(input,105,FOLLOW_31); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_14, grammarAccess.getAccessExprAccess().getColonEqualsSignKeyword_1_2_2_0_0_1());
            	                  
            	            }

            	            }


            	            }

            	            // InternalSpear.g:4305:3: ( (lv_value_15_0= ruleExpr ) )
            	            // InternalSpear.g:4306:1: (lv_value_15_0= ruleExpr )
            	            {
            	            // InternalSpear.g:4306:1: (lv_value_15_0= ruleExpr )
            	            // InternalSpear.g:4307:3: lv_value_15_0= ruleExpr
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getAccessExprAccess().getValueExprParserRuleCall_1_2_2_1_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_44);
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

            	    otherlv_16=(Token)match(input,55,FOLLOW_65); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_16, grammarAccess.getAccessExprAccess().getRightSquareBracketKeyword_1_2_3());
            	          
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
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
    // InternalSpear.g:4335:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalSpear.g:4336:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalSpear.g:4337:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
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
    // InternalSpear.g:4344:1: ruleAtomicExpr returns [EObject current=null] : (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) ) ;
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
            // InternalSpear.g:4347:28: ( (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) ) )
            // InternalSpear.g:4348:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )
            {
            // InternalSpear.g:4348:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )
            int alt97=11;
            alt97 = dfa97.predict(input);
            switch (alt97) {
                case 1 :
                    // InternalSpear.g:4349:5: this_LiteralExpr_0= ruleLiteralExpr
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
                    // InternalSpear.g:4358:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalSpear.g:4358:6: ( () ( (otherlv_2= RULE_ID ) ) )
                    // InternalSpear.g:4358:7: () ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSpear.g:4358:7: ()
                    // InternalSpear.g:4359:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4364:2: ( (otherlv_2= RULE_ID ) )
                    // InternalSpear.g:4365:1: (otherlv_2= RULE_ID )
                    {
                    // InternalSpear.g:4365:1: (otherlv_2= RULE_ID )
                    // InternalSpear.g:4366:3: otherlv_2= RULE_ID
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
                    // InternalSpear.g:4378:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    {
                    // InternalSpear.g:4378:6: ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' )
                    // InternalSpear.g:4378:7: () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|'
                    {
                    // InternalSpear.g:4378:7: ()
                    // InternalSpear.g:4379:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getMultipleIdExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_1());
                          
                    }
                    // InternalSpear.g:4388:1: ( (otherlv_5= RULE_ID ) )
                    // InternalSpear.g:4389:1: (otherlv_5= RULE_ID )
                    {
                    // InternalSpear.g:4389:1: (otherlv_5= RULE_ID )
                    // InternalSpear.g:4390:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_2_0()); 
                      	
                    }

                    }


                    }

                    // InternalSpear.g:4401:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==39) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalSpear.g:4401:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getAtomicExprAccess().getCommaKeyword_2_3_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4405:1: ( (otherlv_7= RULE_ID ) )
                    	    // InternalSpear.g:4406:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalSpear.g:4406:1: (otherlv_7= RULE_ID )
                    	    // InternalSpear.g:4407:3: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_7, grammarAccess.getAtomicExprAccess().getIdsIdRefCrossReference_2_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_2_4());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSpear.g:4423:6: ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? )
                    {
                    // InternalSpear.g:4423:6: ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? )
                    // InternalSpear.g:4423:7: () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )?
                    {
                    // InternalSpear.g:4423:7: ()
                    // InternalSpear.g:4424:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIfThenElseExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_10=(Token)match(input,106,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExprAccess().getIfKeyword_3_1());
                          
                    }
                    // InternalSpear.g:4433:1: ( (lv_cond_11_0= ruleExpr ) )
                    // InternalSpear.g:4434:1: (lv_cond_11_0= ruleExpr )
                    {
                    // InternalSpear.g:4434:1: (lv_cond_11_0= ruleExpr )
                    // InternalSpear.g:4435:3: lv_cond_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getCondExprParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_47);
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

                    otherlv_12=(Token)match(input,64,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getAtomicExprAccess().getThenKeyword_3_3());
                          
                    }
                    // InternalSpear.g:4455:1: ( (lv_then_13_0= ruleExpr ) )
                    // InternalSpear.g:4456:1: (lv_then_13_0= ruleExpr )
                    {
                    // InternalSpear.g:4456:1: (lv_then_13_0= ruleExpr )
                    // InternalSpear.g:4457:3: lv_then_13_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getThenExprParserRuleCall_3_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_69);
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

                    // InternalSpear.g:4473:2: ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==107) ) {
                        int LA89_1 = input.LA(2);

                        if ( (synpred18_InternalSpear()) ) {
                            alt89=1;
                        }
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalSpear.g:4473:3: ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) )
                            {
                            // InternalSpear.g:4473:3: ( ( 'else' )=>otherlv_14= 'else' )
                            // InternalSpear.g:4473:4: ( 'else' )=>otherlv_14= 'else'
                            {
                            otherlv_14=(Token)match(input,107,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getAtomicExprAccess().getElseKeyword_3_5_0());
                                  
                            }

                            }

                            // InternalSpear.g:4478:2: ( (lv_else_15_0= ruleExpr ) )
                            // InternalSpear.g:4479:1: (lv_else_15_0= ruleExpr )
                            {
                            // InternalSpear.g:4479:1: (lv_else_15_0= ruleExpr )
                            // InternalSpear.g:4480:3: lv_else_15_0= ruleExpr
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
                    // InternalSpear.g:4497:6: ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' )
                    {
                    // InternalSpear.g:4497:6: ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' )
                    // InternalSpear.g:4497:7: () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}'
                    {
                    // InternalSpear.g:4497:7: ()
                    // InternalSpear.g:4498:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRecordExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_17=(Token)match(input,108,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getAtomicExprAccess().getNewKeyword_4_1());
                          
                    }
                    // InternalSpear.g:4507:1: ( (otherlv_18= RULE_ID ) )
                    // InternalSpear.g:4508:1: (otherlv_18= RULE_ID )
                    {
                    // InternalSpear.g:4508:1: (otherlv_18= RULE_ID )
                    // InternalSpear.g:4509:3: otherlv_18= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_18, grammarAccess.getAtomicExprAccess().getTypeRecordTypeDefCrossReference_4_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_4_3());
                          
                    }
                    // InternalSpear.g:4524:1: ( (lv_fieldExprs_20_0= ruleFieldExpr ) )
                    // InternalSpear.g:4525:1: (lv_fieldExprs_20_0= ruleFieldExpr )
                    {
                    // InternalSpear.g:4525:1: (lv_fieldExprs_20_0= ruleFieldExpr )
                    // InternalSpear.g:4526:3: lv_fieldExprs_20_0= ruleFieldExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsFieldExprParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
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

                    // InternalSpear.g:4542:2: (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==39) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // InternalSpear.g:4542:4: otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) )
                    	    {
                    	    otherlv_21=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_21, grammarAccess.getAtomicExprAccess().getCommaKeyword_4_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4546:1: ( (lv_fieldExprs_22_0= ruleFieldExpr ) )
                    	    // InternalSpear.g:4547:1: (lv_fieldExprs_22_0= ruleFieldExpr )
                    	    {
                    	    // InternalSpear.g:4547:1: (lv_fieldExprs_22_0= ruleFieldExpr )
                    	    // InternalSpear.g:4548:3: lv_fieldExprs_22_0= ruleFieldExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFieldExprsFieldExprParserRuleCall_4_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_41);
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
                    	    break loop90;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_4_6());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSpear.g:4569:6: ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' )
                    {
                    // InternalSpear.g:4569:6: ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' )
                    // InternalSpear.g:4569:7: () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}'
                    {
                    // InternalSpear.g:4569:7: ()
                    // InternalSpear.g:4570:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFieldlessRecordExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_25=(Token)match(input,108,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getAtomicExprAccess().getNewKeyword_5_1());
                          
                    }
                    // InternalSpear.g:4579:1: ( (otherlv_26= RULE_ID ) )
                    // InternalSpear.g:4580:1: (otherlv_26= RULE_ID )
                    {
                    // InternalSpear.g:4580:1: (otherlv_26= RULE_ID )
                    // InternalSpear.g:4581:3: otherlv_26= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_26=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_26, grammarAccess.getAtomicExprAccess().getTypeRecordTypeDefCrossReference_5_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,52,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_5_3());
                          
                    }
                    // InternalSpear.g:4596:1: ( (lv_exprs_28_0= ruleExpr ) )
                    // InternalSpear.g:4597:1: (lv_exprs_28_0= ruleExpr )
                    {
                    // InternalSpear.g:4597:1: (lv_exprs_28_0= ruleExpr )
                    // InternalSpear.g:4598:3: lv_exprs_28_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_5_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
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

                    // InternalSpear.g:4614:2: (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==39) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalSpear.g:4614:4: otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) )
                    	    {
                    	    otherlv_29=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_29, grammarAccess.getAtomicExprAccess().getCommaKeyword_5_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4618:1: ( (lv_exprs_30_0= ruleExpr ) )
                    	    // InternalSpear.g:4619:1: (lv_exprs_30_0= ruleExpr )
                    	    {
                    	    // InternalSpear.g:4619:1: (lv_exprs_30_0= ruleExpr )
                    	    // InternalSpear.g:4620:3: lv_exprs_30_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_5_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_41);
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
                    	    break loop91;
                        }
                    } while (true);

                    otherlv_31=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_5_6());
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSpear.g:4641:6: ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' )
                    {
                    // InternalSpear.g:4641:6: ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' )
                    // InternalSpear.g:4641:7: () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']'
                    {
                    // InternalSpear.g:4641:7: ()
                    // InternalSpear.g:4642:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getArrayExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_33=(Token)match(input,108,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getAtomicExprAccess().getNewKeyword_6_1());
                          
                    }
                    // InternalSpear.g:4651:1: ( (otherlv_34= RULE_ID ) )
                    // InternalSpear.g:4652:1: (otherlv_34= RULE_ID )
                    {
                    // InternalSpear.g:4652:1: (otherlv_34= RULE_ID )
                    // InternalSpear.g:4653:3: otherlv_34= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_34=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_34, grammarAccess.getAtomicExprAccess().getTypeArrayTypeDefCrossReference_6_2_0()); 
                      	
                    }

                    }


                    }

                    otherlv_35=(Token)match(input,54,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_6_3());
                          
                    }
                    // InternalSpear.g:4668:1: ( (lv_exprs_36_0= ruleExpr ) )
                    // InternalSpear.g:4669:1: (lv_exprs_36_0= ruleExpr )
                    {
                    // InternalSpear.g:4669:1: (lv_exprs_36_0= ruleExpr )
                    // InternalSpear.g:4670:3: lv_exprs_36_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_70);
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

                    // InternalSpear.g:4686:2: (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==39) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // InternalSpear.g:4686:4: otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) )
                    	    {
                    	    otherlv_37=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_37, grammarAccess.getAtomicExprAccess().getCommaKeyword_6_5_0());
                    	          
                    	    }
                    	    // InternalSpear.g:4690:1: ( (lv_exprs_38_0= ruleExpr ) )
                    	    // InternalSpear.g:4691:1: (lv_exprs_38_0= ruleExpr )
                    	    {
                    	    // InternalSpear.g:4691:1: (lv_exprs_38_0= ruleExpr )
                    	    // InternalSpear.g:4692:3: lv_exprs_38_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_6_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_70);
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
                    	    break loop92;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_39, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalSpear.g:4713:6: ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' )
                    {
                    // InternalSpear.g:4713:6: ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' )
                    // InternalSpear.g:4713:7: () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')'
                    {
                    // InternalSpear.g:4713:7: ()
                    // InternalSpear.g:4714:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getPatternCallAction_7_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4719:2: ( (otherlv_41= RULE_ID ) )
                    // InternalSpear.g:4720:1: (otherlv_41= RULE_ID )
                    {
                    // InternalSpear.g:4720:1: (otherlv_41= RULE_ID )
                    // InternalSpear.g:4721:3: otherlv_41= RULE_ID
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

                    otherlv_42=(Token)match(input,38,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_7_2());
                          
                    }
                    // InternalSpear.g:4736:1: ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==RULE_ID||LA94_0==RULE_INT||LA94_0==38||LA94_0==45||LA94_0==63||LA94_0==70||(LA94_0>=76 && LA94_0<=82)||LA94_0==94||LA94_0==96||LA94_0==100||LA94_0==106||(LA94_0>=108 && LA94_0<=114)) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // InternalSpear.g:4736:2: ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )*
                            {
                            // InternalSpear.g:4736:2: ( (lv_args_43_0= ruleExpr ) )
                            // InternalSpear.g:4737:1: (lv_args_43_0= ruleExpr )
                            {
                            // InternalSpear.g:4737:1: (lv_args_43_0= ruleExpr )
                            // InternalSpear.g:4738:3: lv_args_43_0= ruleExpr
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

                            // InternalSpear.g:4754:2: (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )*
                            loop93:
                            do {
                                int alt93=2;
                                int LA93_0 = input.LA(1);

                                if ( (LA93_0==39) ) {
                                    alt93=1;
                                }


                                switch (alt93) {
                            	case 1 :
                            	    // InternalSpear.g:4754:4: otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) )
                            	    {
                            	    otherlv_44=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_44, grammarAccess.getAtomicExprAccess().getCommaKeyword_7_3_1_0());
                            	          
                            	    }
                            	    // InternalSpear.g:4758:1: ( (lv_args_45_0= ruleExpr ) )
                            	    // InternalSpear.g:4759:1: (lv_args_45_0= ruleExpr )
                            	    {
                            	    // InternalSpear.g:4759:1: (lv_args_45_0= ruleExpr )
                            	    // InternalSpear.g:4760:3: lv_args_45_0= ruleExpr
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
                            	    break loop93;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_46=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_46, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_7_4());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSpear.g:4781:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' )
                    {
                    // InternalSpear.g:4781:6: ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' )
                    // InternalSpear.g:4781:7: () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')'
                    {
                    // InternalSpear.g:4781:7: ()
                    // InternalSpear.g:4782:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSpecificationCallAction_8_0(),
                                  current);
                          
                    }

                    }

                    otherlv_48=(Token)match(input,109,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_48, grammarAccess.getAtomicExprAccess().getSpecKeyword_8_1());
                          
                    }
                    // InternalSpear.g:4791:1: ( (otherlv_49= RULE_ID ) )
                    // InternalSpear.g:4792:1: (otherlv_49= RULE_ID )
                    {
                    // InternalSpear.g:4792:1: (otherlv_49= RULE_ID )
                    // InternalSpear.g:4793:3: otherlv_49= RULE_ID
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

                    otherlv_50=(Token)match(input,38,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_50, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_8_3());
                          
                    }
                    // InternalSpear.g:4808:1: ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==RULE_ID||LA96_0==RULE_INT||LA96_0==38||LA96_0==45||LA96_0==63||LA96_0==70||(LA96_0>=76 && LA96_0<=82)||LA96_0==94||LA96_0==96||LA96_0==100||LA96_0==106||(LA96_0>=108 && LA96_0<=114)) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // InternalSpear.g:4808:2: ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )*
                            {
                            // InternalSpear.g:4808:2: ( (lv_args_51_0= ruleExpr ) )
                            // InternalSpear.g:4809:1: (lv_args_51_0= ruleExpr )
                            {
                            // InternalSpear.g:4809:1: (lv_args_51_0= ruleExpr )
                            // InternalSpear.g:4810:3: lv_args_51_0= ruleExpr
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

                            // InternalSpear.g:4826:2: (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )*
                            loop95:
                            do {
                                int alt95=2;
                                int LA95_0 = input.LA(1);

                                if ( (LA95_0==39) ) {
                                    alt95=1;
                                }


                                switch (alt95) {
                            	case 1 :
                            	    // InternalSpear.g:4826:4: otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) )
                            	    {
                            	    otherlv_52=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_52, grammarAccess.getAtomicExprAccess().getCommaKeyword_8_4_1_0());
                            	          
                            	    }
                            	    // InternalSpear.g:4830:1: ( (lv_args_53_0= ruleExpr ) )
                            	    // InternalSpear.g:4831:1: (lv_args_53_0= ruleExpr )
                            	    {
                            	    // InternalSpear.g:4831:1: (lv_args_53_0= ruleExpr )
                            	    // InternalSpear.g:4832:3: lv_args_53_0= ruleExpr
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
                            	    break loop95;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_54=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_8_5());
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalSpear.g:4854:5: this_UnusedExpr_55= ruleUnusedExpr
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
                    // InternalSpear.g:4863:6: (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' )
                    {
                    // InternalSpear.g:4863:6: (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' )
                    // InternalSpear.g:4863:8: otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')'
                    {
                    otherlv_56=(Token)match(input,38,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_56, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_10_1()); 
                          
                    }
                    pushFollow(FOLLOW_37);
                    this_Expr_57=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_57; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_58=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:4888:1: entryRuleLiteralExpr returns [EObject current=null] : iv_ruleLiteralExpr= ruleLiteralExpr EOF ;
    public final EObject entryRuleLiteralExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpr = null;


        try {
            // InternalSpear.g:4889:2: (iv_ruleLiteralExpr= ruleLiteralExpr EOF )
            // InternalSpear.g:4890:2: iv_ruleLiteralExpr= ruleLiteralExpr EOF
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
    // InternalSpear.g:4897:1: ruleLiteralExpr returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) ;
    public final EObject ruleLiteralExpr() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        AntlrDatatypeRuleToken lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:4900:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) ) )
            // InternalSpear.g:4901:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            {
            // InternalSpear.g:4901:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? ) | ( () ( (lv_value_4_0= ruleBOOL ) ) ) | ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? ) )
            int alt100=3;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_INT) ) {
                int LA100_1 = input.LA(2);

                if ( (LA100_1==EOF||LA100_1==RULE_ID||(LA100_1>=16 && LA100_1<=17)||(LA100_1>=22 && LA100_1<=34)||(LA100_1>=39 && LA100_1<=40)||(LA100_1>=44 && LA100_1<=45)||(LA100_1>=47 && LA100_1<=50)||(LA100_1>=52 && LA100_1<=55)||LA100_1==62||(LA100_1>=64 && LA100_1<=69)||(LA100_1>=71 && LA100_1<=75)||(LA100_1>=83 && LA100_1<=84)||(LA100_1>=86 && LA100_1<=87)||(LA100_1>=89 && LA100_1<=99)||LA100_1==101||LA100_1==105||LA100_1==107) ) {
                    alt100=1;
                }
                else if ( (LA100_1==104) ) {
                    int LA100_4 = input.LA(3);

                    if ( (LA100_4==RULE_ID) ) {
                        alt100=1;
                    }
                    else if ( (LA100_4==RULE_INT) ) {
                        alt100=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA100_0>=111 && LA100_0<=114)) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // InternalSpear.g:4901:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    {
                    // InternalSpear.g:4901:2: ( () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )? )
                    // InternalSpear.g:4901:3: () ( (lv_value_1_0= RULE_INT ) ) ( (otherlv_2= RULE_ID ) )?
                    {
                    // InternalSpear.g:4901:3: ()
                    // InternalSpear.g:4902:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getIntLiteralAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4907:2: ( (lv_value_1_0= RULE_INT ) )
                    // InternalSpear.g:4908:1: (lv_value_1_0= RULE_INT )
                    {
                    // InternalSpear.g:4908:1: (lv_value_1_0= RULE_INT )
                    // InternalSpear.g:4909:3: lv_value_1_0= RULE_INT
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

                    // InternalSpear.g:4925:2: ( (otherlv_2= RULE_ID ) )?
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==RULE_ID) ) {
                        int LA98_1 = input.LA(2);

                        if ( (LA98_1==EOF||LA98_1==RULE_ID||(LA98_1>=16 && LA98_1<=17)||(LA98_1>=22 && LA98_1<=34)||(LA98_1>=39 && LA98_1<=40)||(LA98_1>=44 && LA98_1<=45)||(LA98_1>=47 && LA98_1<=50)||(LA98_1>=52 && LA98_1<=55)||LA98_1==62||(LA98_1>=64 && LA98_1<=69)||(LA98_1>=71 && LA98_1<=75)||(LA98_1>=83 && LA98_1<=84)||(LA98_1>=86 && LA98_1<=87)||(LA98_1>=89 && LA98_1<=99)||LA98_1==101||(LA98_1>=104 && LA98_1<=105)||LA98_1==107) ) {
                            alt98=1;
                        }
                    }
                    switch (alt98) {
                        case 1 :
                            // InternalSpear.g:4926:1: (otherlv_2= RULE_ID )
                            {
                            // InternalSpear.g:4926:1: (otherlv_2= RULE_ID )
                            // InternalSpear.g:4927:3: otherlv_2= RULE_ID
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
                    // InternalSpear.g:4939:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    {
                    // InternalSpear.g:4939:6: ( () ( (lv_value_4_0= ruleBOOL ) ) )
                    // InternalSpear.g:4939:7: () ( (lv_value_4_0= ruleBOOL ) )
                    {
                    // InternalSpear.g:4939:7: ()
                    // InternalSpear.g:4940:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getBoolLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4945:2: ( (lv_value_4_0= ruleBOOL ) )
                    // InternalSpear.g:4946:1: (lv_value_4_0= ruleBOOL )
                    {
                    // InternalSpear.g:4946:1: (lv_value_4_0= ruleBOOL )
                    // InternalSpear.g:4947:3: lv_value_4_0= ruleBOOL
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
                    // InternalSpear.g:4964:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    {
                    // InternalSpear.g:4964:6: ( () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )? )
                    // InternalSpear.g:4964:7: () ( (lv_value_6_0= ruleREAL ) ) ( (otherlv_7= RULE_ID ) )?
                    {
                    // InternalSpear.g:4964:7: ()
                    // InternalSpear.g:4965:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralExprAccess().getRealLiteralAction_2_0(),
                                  current);
                          
                    }

                    }

                    // InternalSpear.g:4970:2: ( (lv_value_6_0= ruleREAL ) )
                    // InternalSpear.g:4971:1: (lv_value_6_0= ruleREAL )
                    {
                    // InternalSpear.g:4971:1: (lv_value_6_0= ruleREAL )
                    // InternalSpear.g:4972:3: lv_value_6_0= ruleREAL
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

                    // InternalSpear.g:4988:2: ( (otherlv_7= RULE_ID ) )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==RULE_ID) ) {
                        int LA99_1 = input.LA(2);

                        if ( (LA99_1==EOF||LA99_1==RULE_ID||(LA99_1>=16 && LA99_1<=17)||(LA99_1>=22 && LA99_1<=34)||(LA99_1>=39 && LA99_1<=40)||(LA99_1>=44 && LA99_1<=45)||(LA99_1>=47 && LA99_1<=50)||(LA99_1>=52 && LA99_1<=55)||LA99_1==62||(LA99_1>=64 && LA99_1<=69)||(LA99_1>=71 && LA99_1<=75)||(LA99_1>=83 && LA99_1<=84)||(LA99_1>=86 && LA99_1<=87)||(LA99_1>=89 && LA99_1<=99)||LA99_1==101||(LA99_1>=104 && LA99_1<=105)||LA99_1==107) ) {
                            alt99=1;
                        }
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalSpear.g:4989:1: (otherlv_7= RULE_ID )
                            {
                            // InternalSpear.g:4989:1: (otherlv_7= RULE_ID )
                            // InternalSpear.g:4990:3: otherlv_7= RULE_ID
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
    // InternalSpear.g:5009:1: entryRuleUnusedExpr returns [EObject current=null] : iv_ruleUnusedExpr= ruleUnusedExpr EOF ;
    public final EObject entryRuleUnusedExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnusedExpr = null;


        try {
            // InternalSpear.g:5010:2: (iv_ruleUnusedExpr= ruleUnusedExpr EOF )
            // InternalSpear.g:5011:2: iv_ruleUnusedExpr= ruleUnusedExpr EOF
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
    // InternalSpear.g:5018:1: ruleUnusedExpr returns [EObject current=null] : ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' ) ;
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
            // InternalSpear.g:5021:28: ( ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' ) )
            // InternalSpear.g:5022:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' )
            {
            // InternalSpear.g:5022:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')' )
            // InternalSpear.g:5022:2: () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '#' otherlv_6= '==' otherlv_7= 'spec' ( (otherlv_8= RULE_ID ) ) otherlv_9= '(' ( (lv_args_10_0= ruleExpr ) ) (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )* otherlv_13= ')'
            {
            // InternalSpear.g:5022:2: ()
            // InternalSpear.g:5023:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnusedExprAccess().getNormalizedCallAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,110,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnusedExprAccess().getNumberSignKeyword_1());
                  
            }
            // InternalSpear.g:5032:1: ( (otherlv_2= RULE_ID ) )
            // InternalSpear.g:5033:1: (otherlv_2= RULE_ID )
            {
            // InternalSpear.g:5033:1: (otherlv_2= RULE_ID )
            // InternalSpear.g:5034:3: otherlv_2= RULE_ID
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

            // InternalSpear.g:5045:2: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==39) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalSpear.g:5045:4: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getUnusedExprAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalSpear.g:5049:1: ( (otherlv_4= RULE_ID ) )
            	    // InternalSpear.g:5050:1: (otherlv_4= RULE_ID )
            	    {
            	    // InternalSpear.g:5050:1: (otherlv_4= RULE_ID )
            	    // InternalSpear.g:5051:3: otherlv_4= RULE_ID
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
            	    break loop101;
                }
            } while (true);

            otherlv_5=(Token)match(input,110,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getUnusedExprAccess().getNumberSignKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,92,FOLLOW_74); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getUnusedExprAccess().getEqualsSignEqualsSignKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,109,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getUnusedExprAccess().getSpecKeyword_6());
                  
            }
            // InternalSpear.g:5074:1: ( (otherlv_8= RULE_ID ) )
            // InternalSpear.g:5075:1: (otherlv_8= RULE_ID )
            {
            // InternalSpear.g:5075:1: (otherlv_8= RULE_ID )
            // InternalSpear.g:5076:3: otherlv_8= RULE_ID
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

            otherlv_9=(Token)match(input,38,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getUnusedExprAccess().getLeftParenthesisKeyword_8());
                  
            }
            // InternalSpear.g:5091:1: ( (lv_args_10_0= ruleExpr ) )
            // InternalSpear.g:5092:1: (lv_args_10_0= ruleExpr )
            {
            // InternalSpear.g:5092:1: (lv_args_10_0= ruleExpr )
            // InternalSpear.g:5093:3: lv_args_10_0= ruleExpr
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

            // InternalSpear.g:5109:2: (otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==39) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalSpear.g:5109:4: otherlv_11= ',' ( (lv_args_12_0= ruleExpr ) )
            	    {
            	    otherlv_11=(Token)match(input,39,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getUnusedExprAccess().getCommaKeyword_10_0());
            	          
            	    }
            	    // InternalSpear.g:5113:1: ( (lv_args_12_0= ruleExpr ) )
            	    // InternalSpear.g:5114:1: (lv_args_12_0= ruleExpr )
            	    {
            	    // InternalSpear.g:5114:1: (lv_args_12_0= ruleExpr )
            	    // InternalSpear.g:5115:3: lv_args_12_0= ruleExpr
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
            	    break loop102;
                }
            } while (true);

            otherlv_13=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:5145:1: entryRuleFieldExpr returns [EObject current=null] : iv_ruleFieldExpr= ruleFieldExpr EOF ;
    public final EObject entryRuleFieldExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldExpr = null;


        try {
            // InternalSpear.g:5146:2: (iv_ruleFieldExpr= ruleFieldExpr EOF )
            // InternalSpear.g:5147:2: iv_ruleFieldExpr= ruleFieldExpr EOF
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
    // InternalSpear.g:5154:1: ruleFieldExpr returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) ;
    public final EObject ruleFieldExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5157:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) ) )
            // InternalSpear.g:5158:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            {
            // InternalSpear.g:5158:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) ) )
            // InternalSpear.g:5158:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expr_2_0= ruleExpr ) )
            {
            // InternalSpear.g:5158:2: ( (otherlv_0= RULE_ID ) )
            // InternalSpear.g:5159:1: (otherlv_0= RULE_ID )
            {
            // InternalSpear.g:5159:1: (otherlv_0= RULE_ID )
            // InternalSpear.g:5160:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldExprRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldExprAccess().getFieldFieldTypeCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,46,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldExprAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalSpear.g:5175:1: ( (lv_expr_2_0= ruleExpr ) )
            // InternalSpear.g:5176:1: (lv_expr_2_0= ruleExpr )
            {
            // InternalSpear.g:5176:1: (lv_expr_2_0= ruleExpr )
            // InternalSpear.g:5177:3: lv_expr_2_0= ruleExpr
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
    // InternalSpear.g:5201:1: entryRuleBOOL returns [String current=null] : iv_ruleBOOL= ruleBOOL EOF ;
    public final String entryRuleBOOL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOL = null;


        try {
            // InternalSpear.g:5202:2: (iv_ruleBOOL= ruleBOOL EOF )
            // InternalSpear.g:5203:2: iv_ruleBOOL= ruleBOOL EOF
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
    // InternalSpear.g:5210:1: ruleBOOL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) ;
    public final AntlrDatatypeRuleToken ruleBOOL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BOOLEAN_TRUE_0 = null;

        AntlrDatatypeRuleToken this_BOOLEAN_FALSE_1 = null;


         enterRule(); 
            
        try {
            // InternalSpear.g:5213:28: ( (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE ) )
            // InternalSpear.g:5214:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            {
            // InternalSpear.g:5214:1: (this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE | this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=111 && LA103_0<=112)) ) {
                alt103=1;
            }
            else if ( ((LA103_0>=113 && LA103_0<=114)) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalSpear.g:5215:5: this_BOOLEAN_TRUE_0= ruleBOOLEAN_TRUE
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
                    // InternalSpear.g:5227:5: this_BOOLEAN_FALSE_1= ruleBOOLEAN_FALSE
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
    // InternalSpear.g:5245:1: entryRuleBOOLEAN_TRUE returns [String current=null] : iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF ;
    public final String entryRuleBOOLEAN_TRUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_TRUE = null;


        try {
            // InternalSpear.g:5246:2: (iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF )
            // InternalSpear.g:5247:2: iv_ruleBOOLEAN_TRUE= ruleBOOLEAN_TRUE EOF
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
    // InternalSpear.g:5254:1: ruleBOOLEAN_TRUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TRUE' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_TRUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:5257:28: ( (kw= 'TRUE' | kw= 'true' ) )
            // InternalSpear.g:5258:1: (kw= 'TRUE' | kw= 'true' )
            {
            // InternalSpear.g:5258:1: (kw= 'TRUE' | kw= 'true' )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==111) ) {
                alt104=1;
            }
            else if ( (LA104_0==112) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // InternalSpear.g:5259:2: kw= 'TRUE'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_TRUEAccess().getTRUEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5266:2: kw= 'true'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:5279:1: entryRuleBOOLEAN_FALSE returns [String current=null] : iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF ;
    public final String entryRuleBOOLEAN_FALSE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN_FALSE = null;


        try {
            // InternalSpear.g:5280:2: (iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF )
            // InternalSpear.g:5281:2: iv_ruleBOOLEAN_FALSE= ruleBOOLEAN_FALSE EOF
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
    // InternalSpear.g:5288:1: ruleBOOLEAN_FALSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'FALSE' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN_FALSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:5291:28: ( (kw= 'FALSE' | kw= 'false' ) )
            // InternalSpear.g:5292:1: (kw= 'FALSE' | kw= 'false' )
            {
            // InternalSpear.g:5292:1: (kw= 'FALSE' | kw= 'false' )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==113) ) {
                alt105=1;
            }
            else if ( (LA105_0==114) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalSpear.g:5293:2: kw= 'FALSE'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBOOLEAN_FALSEAccess().getFALSEKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalSpear.g:5300:2: kw= 'false'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
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
    // InternalSpear.g:5313:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // InternalSpear.g:5314:2: (iv_ruleREAL= ruleREAL EOF )
            // InternalSpear.g:5315:2: iv_ruleREAL= ruleREAL EOF
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
        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // InternalSpear.g:5322:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // InternalSpear.g:5325:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalSpear.g:5326:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalSpear.g:5326:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalSpear.g:5326:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,104,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
                  
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
    // $ANTLR end "ruleREAL"

    // $ANTLR start synpred1_InternalSpear
    public final void synpred1_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:1433:3: ( ( () ( ( '*' ) ) ) )
        // InternalSpear.g:1433:4: ( () ( ( '*' ) ) )
        {
        // InternalSpear.g:1433:4: ( () ( ( '*' ) ) )
        // InternalSpear.g:1433:5: () ( ( '*' ) )
        {
        // InternalSpear.g:1433:5: ()
        // InternalSpear.g:1434:1: 
        {
        }

        // InternalSpear.g:1434:2: ( ( '*' ) )
        // InternalSpear.g:1435:1: ( '*' )
        {
        // InternalSpear.g:1435:1: ( '*' )
        // InternalSpear.g:1436:2: '*'
        {
        match(input,49,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSpear

    // $ANTLR start synpred2_InternalSpear
    public final void synpred2_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:1509:3: ( ( () ( ( '/' ) ) ) )
        // InternalSpear.g:1509:4: ( () ( ( '/' ) ) )
        {
        // InternalSpear.g:1509:4: ( () ( ( '/' ) ) )
        // InternalSpear.g:1509:5: () ( ( '/' ) )
        {
        // InternalSpear.g:1509:5: ()
        // InternalSpear.g:1510:1: 
        {
        }

        // InternalSpear.g:1510:2: ( ( '/' ) )
        // InternalSpear.g:1511:1: ( '/' )
        {
        // InternalSpear.g:1511:1: ( '/' )
        // InternalSpear.g:1512:2: '/'
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSpear

    // $ANTLR start synpred3_InternalSpear
    public final void synpred3_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:2778:3: ( ( () ( ( ( '=>' | 'implies' ) ) ) ) )
        // InternalSpear.g:2778:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        {
        // InternalSpear.g:2778:4: ( () ( ( ( '=>' | 'implies' ) ) ) )
        // InternalSpear.g:2778:5: () ( ( ( '=>' | 'implies' ) ) )
        {
        // InternalSpear.g:2778:5: ()
        // InternalSpear.g:2779:1: 
        {
        }

        // InternalSpear.g:2779:2: ( ( ( '=>' | 'implies' ) ) )
        // InternalSpear.g:2780:1: ( ( '=>' | 'implies' ) )
        {
        // InternalSpear.g:2780:1: ( ( '=>' | 'implies' ) )
        // InternalSpear.g:2781:1: ( '=>' | 'implies' )
        {
        if ( (input.LA(1)>=65 && input.LA(1)<=66) ) {
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
        // InternalSpear.g:2875:3: ( ( () ( ( ( 'or' | 'xor' ) ) ) ) )
        // InternalSpear.g:2875:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        {
        // InternalSpear.g:2875:4: ( () ( ( ( 'or' | 'xor' ) ) ) )
        // InternalSpear.g:2875:5: () ( ( ( 'or' | 'xor' ) ) )
        {
        // InternalSpear.g:2875:5: ()
        // InternalSpear.g:2876:1: 
        {
        }

        // InternalSpear.g:2876:2: ( ( ( 'or' | 'xor' ) ) )
        // InternalSpear.g:2877:1: ( ( 'or' | 'xor' ) )
        {
        // InternalSpear.g:2877:1: ( ( 'or' | 'xor' ) )
        // InternalSpear.g:2878:1: ( 'or' | 'xor' )
        {
        if ( (input.LA(1)>=67 && input.LA(1)<=68) ) {
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
        // InternalSpear.g:2972:3: ( ( () ( ( 'and' ) ) ) )
        // InternalSpear.g:2972:4: ( () ( ( 'and' ) ) )
        {
        // InternalSpear.g:2972:4: ( () ( ( 'and' ) ) )
        // InternalSpear.g:2972:5: () ( ( 'and' ) )
        {
        // InternalSpear.g:2972:5: ()
        // InternalSpear.g:2973:1: 
        {
        }

        // InternalSpear.g:2973:2: ( ( 'and' ) )
        // InternalSpear.g:2974:1: ( 'and' )
        {
        // InternalSpear.g:2974:1: ( 'and' )
        // InternalSpear.g:2975:2: 'and'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalSpear

    // $ANTLR start synpred6_InternalSpear
    public final void synpred6_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3067:4: ( 'until' )
        // InternalSpear.g:3067:6: 'until'
        {
        match(input,71,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalSpear

    // $ANTLR start synpred7_InternalSpear
    public final void synpred7_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:3130:3: ( ( () ( ( ( 'T' | 'triggers' ) ) ) ) )
        // InternalSpear.g:3130:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        {
        // InternalSpear.g:3130:4: ( () ( ( ( 'T' | 'triggers' ) ) ) )
        // InternalSpear.g:3130:5: () ( ( ( 'T' | 'triggers' ) ) )
        {
        // InternalSpear.g:3130:5: ()
        // InternalSpear.g:3131:1: 
        {
        }

        // InternalSpear.g:3131:2: ( ( ( 'T' | 'triggers' ) ) )
        // InternalSpear.g:3132:1: ( ( 'T' | 'triggers' ) )
        {
        // InternalSpear.g:3132:1: ( ( 'T' | 'triggers' ) )
        // InternalSpear.g:3133:1: ( 'T' | 'triggers' )
        {
        if ( (input.LA(1)>=72 && input.LA(1)<=73) ) {
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
        // InternalSpear.g:3227:3: ( ( () ( ( ( 'S' | 'since' ) ) ) ) )
        // InternalSpear.g:3227:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        {
        // InternalSpear.g:3227:4: ( () ( ( ( 'S' | 'since' ) ) ) )
        // InternalSpear.g:3227:5: () ( ( ( 'S' | 'since' ) ) )
        {
        // InternalSpear.g:3227:5: ()
        // InternalSpear.g:3228:1: 
        {
        }

        // InternalSpear.g:3228:2: ( ( ( 'S' | 'since' ) ) )
        // InternalSpear.g:3229:1: ( ( 'S' | 'since' ) )
        {
        // InternalSpear.g:3229:1: ( ( 'S' | 'since' ) )
        // InternalSpear.g:3230:1: ( 'S' | 'since' )
        {
        if ( (input.LA(1)>=74 && input.LA(1)<=75) ) {
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
        // InternalSpear.g:3469:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalSpear.g:3469:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalSpear.g:3469:4: ( () ( ( ruleRelationalOp ) ) )
        // InternalSpear.g:3469:5: () ( ( ruleRelationalOp ) )
        {
        // InternalSpear.g:3469:5: ()
        // InternalSpear.g:3470:1: 
        {
        }

        // InternalSpear.g:3470:2: ( ( ruleRelationalOp ) )
        // InternalSpear.g:3471:1: ( ruleRelationalOp )
        {
        // InternalSpear.g:3471:1: ( ruleRelationalOp )
        // InternalSpear.g:3472:1: ruleRelationalOp
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
        // InternalSpear.g:3728:3: ( ( () ( ( ( '+' | '-' ) ) ) ) )
        // InternalSpear.g:3728:4: ( () ( ( ( '+' | '-' ) ) ) )
        {
        // InternalSpear.g:3728:4: ( () ( ( ( '+' | '-' ) ) ) )
        // InternalSpear.g:3728:5: () ( ( ( '+' | '-' ) ) )
        {
        // InternalSpear.g:3728:5: ()
        // InternalSpear.g:3729:1: 
        {
        }

        // InternalSpear.g:3729:2: ( ( ( '+' | '-' ) ) )
        // InternalSpear.g:3730:1: ( ( '+' | '-' ) )
        {
        // InternalSpear.g:3730:1: ( ( '+' | '-' ) )
        // InternalSpear.g:3731:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=95 && input.LA(1)<=96) ) {
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
        // InternalSpear.g:3825:3: ( ( () ( ( ( '*' | '/' | 'mod' ) ) ) ) )
        // InternalSpear.g:3825:4: ( () ( ( ( '*' | '/' | 'mod' ) ) ) )
        {
        // InternalSpear.g:3825:4: ( () ( ( ( '*' | '/' | 'mod' ) ) ) )
        // InternalSpear.g:3825:5: () ( ( ( '*' | '/' | 'mod' ) ) )
        {
        // InternalSpear.g:3825:5: ()
        // InternalSpear.g:3826:1: 
        {
        }

        // InternalSpear.g:3826:2: ( ( ( '*' | '/' | 'mod' ) ) )
        // InternalSpear.g:3827:1: ( ( '*' | '/' | 'mod' ) )
        {
        // InternalSpear.g:3827:1: ( ( '*' | '/' | 'mod' ) )
        // InternalSpear.g:3828:1: ( '*' | '/' | 'mod' )
        {
        if ( (input.LA(1)>=49 && input.LA(1)<=50)||input.LA(1)==97 ) {
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
        // InternalSpear.g:3937:3: ( ( () ( ( ( '->' | 'arrow' ) ) ) ) )
        // InternalSpear.g:3937:4: ( () ( ( ( '->' | 'arrow' ) ) ) )
        {
        // InternalSpear.g:3937:4: ( () ( ( ( '->' | 'arrow' ) ) ) )
        // InternalSpear.g:3937:5: () ( ( ( '->' | 'arrow' ) ) )
        {
        // InternalSpear.g:3937:5: ()
        // InternalSpear.g:3938:1: 
        {
        }

        // InternalSpear.g:3938:2: ( ( ( '->' | 'arrow' ) ) )
        // InternalSpear.g:3939:1: ( ( '->' | 'arrow' ) )
        {
        // InternalSpear.g:3939:1: ( ( '->' | 'arrow' ) )
        // InternalSpear.g:3940:1: ( '->' | 'arrow' )
        {
        if ( (input.LA(1)>=98 && input.LA(1)<=99) ) {
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
        // InternalSpear.g:4108:4: ( 'with' )
        // InternalSpear.g:4108:6: 'with'
        {
        match(input,101,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalSpear

    // $ANTLR start synpred14_InternalSpear
    public final void synpred14_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4179:4: ( ( () '.' ) )
        // InternalSpear.g:4179:5: ( () '.' )
        {
        // InternalSpear.g:4179:5: ( () '.' )
        // InternalSpear.g:4179:6: () '.'
        {
        // InternalSpear.g:4179:6: ()
        // InternalSpear.g:4180:1: 
        {
        }

        match(input,104,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalSpear

    // $ANTLR start synpred15_InternalSpear
    public final void synpred15_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4205:8: ( ( () '{' ( ( RULE_ID ) ) ':=' ) )
        // InternalSpear.g:4205:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        {
        // InternalSpear.g:4205:9: ( () '{' ( ( RULE_ID ) ) ':=' )
        // InternalSpear.g:4205:10: () '{' ( ( RULE_ID ) ) ':='
        {
        // InternalSpear.g:4205:10: ()
        // InternalSpear.g:4206:1: 
        {
        }

        match(input,52,FOLLOW_3); if (state.failed) return ;
        // InternalSpear.g:4207:1: ( ( RULE_ID ) )
        // InternalSpear.g:4208:1: ( RULE_ID )
        {
        // InternalSpear.g:4208:1: ( RULE_ID )
        // InternalSpear.g:4209:2: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_66); if (state.failed) return ;

        }


        }

        match(input,105,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalSpear

    // $ANTLR start synpred16_InternalSpear
    public final void synpred16_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4263:8: ( ( () '[' ) )
        // InternalSpear.g:4263:9: ( () '[' )
        {
        // InternalSpear.g:4263:9: ( () '[' )
        // InternalSpear.g:4263:10: () '['
        {
        // InternalSpear.g:4263:10: ()
        // InternalSpear.g:4264:1: 
        {
        }

        match(input,54,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalSpear

    // $ANTLR start synpred17_InternalSpear
    public final void synpred17_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4293:4: ( ( () ':=' ) )
        // InternalSpear.g:4293:5: ( () ':=' )
        {
        // InternalSpear.g:4293:5: ( () ':=' )
        // InternalSpear.g:4293:6: () ':='
        {
        // InternalSpear.g:4293:6: ()
        // InternalSpear.g:4294:1: 
        {
        }

        match(input,105,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalSpear

    // $ANTLR start synpred18_InternalSpear
    public final void synpred18_InternalSpear_fragment() throws RecognitionException {   
        // InternalSpear.g:4473:4: ( 'else' )
        // InternalSpear.g:4473:6: 'else'
        {
        match(input,107,FOLLOW_2); if (state.failed) return ;

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


    protected DFA54 dfa54 = new DFA54(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA97 dfa97 = new DFA97(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\5\uffff\4\14\4\uffff";
    static final String dfa_3s = "\1\4\1\25\7\4\4\uffff";
    static final String dfa_4s = "\1\4\1\75\3\73\4\66\4\uffff";
    static final String dfa_5s = "\11\uffff\1\2\1\4\1\3\1\1";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\46\uffff\1\3\1\4",
            "\1\10\56\uffff\1\11\4\uffff\1\12\1\5\1\6\1\7",
            "\1\10\56\uffff\1\11\4\uffff\1\12\1\5\1\6\1\7",
            "\1\10\56\uffff\1\11\4\uffff\1\12\1\5\1\6\1\7",
            "\1\14\12\uffff\3\14\44\uffff\1\13",
            "\1\14\12\uffff\3\14\44\uffff\1\13",
            "\1\14\12\uffff\3\14\44\uffff\1\13",
            "\1\14\12\uffff\3\14\44\uffff\1\13",
            "",
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

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1634:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_type_3_0= ruleType ) ) ( (otherlv_4= RULE_ID ) )? ) | ( () ( (lv_name_6_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_8= 'record' otherlv_9= '{' ( (lv_fields_10_0= ruleFieldType ) ) (otherlv_11= ',' ( (lv_fields_12_0= ruleFieldType ) ) )* otherlv_13= '}' ) | ( () ( (lv_name_15_0= RULE_ID ) ) ruleIdTypeDelimiter ( (lv_base_17_0= ruleType ) ) otherlv_18= '[' ( (lv_size_19_0= RULE_INT ) ) otherlv_20= ']' ) | ( () ( (lv_name_22_0= RULE_ID ) ) ruleIdTypeDelimiter otherlv_24= 'enum' otherlv_25= '{' ( (lv_values_26_0= ruleEnumValue ) ) (otherlv_27= ',' ( (lv_values_28_0= ruleEnumValue ) ) )* otherlv_29= '}' ) )";
        }
    }
    static final String dfa_8s = "\1\13\14\uffff";
    static final String dfa_9s = "\1\4\12\0\2\uffff";
    static final String dfa_10s = "\1\153\12\0\2\uffff";
    static final String dfa_11s = "\13\uffff\1\2\1\1";
    static final String dfa_12s = "\1\uffff\1\7\1\0\1\4\1\1\1\5\1\6\1\3\1\2\1\11\1\10\2\uffff}>";
    static final String[] dfa_13s = {
            "\1\13\13\uffff\2\13\4\uffff\15\13\4\uffff\2\13\3\uffff\2\13\1\uffff\4\13\1\uffff\4\13\6\uffff\1\13\1\uffff\6\13\1\uffff\5\13\7\uffff\1\1\1\2\1\uffff\1\3\1\10\1\uffff\1\4\1\5\1\6\1\7\1\11\1\12\5\13\1\uffff\1\13\2\uffff\2\13\1\uffff\1\13",
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
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_1;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "3469:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_2 = input.LA(1);

                         
                        int index75_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA75_4 = input.LA(1);

                         
                        int index75_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA75_8 = input.LA(1);

                         
                        int index75_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA75_7 = input.LA(1);

                         
                        int index75_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA75_3 = input.LA(1);

                         
                        int index75_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA75_5 = input.LA(1);

                         
                        int index75_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA75_6 = input.LA(1);

                         
                        int index75_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA75_10 = input.LA(1);

                         
                        int index75_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA75_9 = input.LA(1);

                         
                        int index75_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalSpear()) ) {s = 12;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index75_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\21\uffff";
    static final String dfa_15s = "\13\uffff\1\16\1\20\4\uffff";
    static final String dfa_16s = "\1\123\1\uffff\1\125\2\uffff\1\125\5\uffff\2\4\4\uffff";
    static final String dfa_17s = "\1\136\1\uffff\1\125\2\uffff\1\125\5\uffff\2\162\4\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\7\1\11\1\12\1\13\1\14\2\uffff\1\4\1\2\1\10\1\6";
    static final String dfa_19s = "\21\uffff}>";
    static final String[] dfa_20s = {
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
            "\1\16\1\uffff\1\16\37\uffff\1\16\6\uffff\1\16\25\uffff\1\15\32\uffff\1\16\1\uffff\1\16\3\uffff\1\16\5\uffff\1\16\1\uffff\7\16",
            "\1\20\1\uffff\1\20\37\uffff\1\20\6\uffff\1\20\25\uffff\1\17\32\uffff\1\20\1\uffff\1\20\3\uffff\1\20\5\uffff\1\20\1\uffff\7\20",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "3537:1: (kw= '<' | (kw= 'less' kw= 'than' ) | kw= '<=' | (kw= 'less' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '>' | (kw= 'greater' kw= 'than' ) | kw= '>=' | (kw= 'greater' kw= 'than' kw= 'or' kw= 'equal' kw= 'to' ) | kw= '==' | (kw= 'equal' kw= 'to' ) | kw= '<>' | (kw= 'not' kw= 'equal' kw= 'to' ) )";
        }
    }
    static final String dfa_21s = "\2\uffff\1\12\16\uffff";
    static final String dfa_22s = "\1\4\1\uffff\1\4\2\uffff\1\4\5\uffff\1\64\1\4\1\uffff\1\46\2\uffff";
    static final String dfa_23s = "\1\162\1\uffff\1\153\2\uffff\1\4\5\uffff\1\66\1\162\1\uffff\1\150\2\uffff";
    static final String dfa_24s = "\1\uffff\1\1\1\uffff\1\3\1\4\1\uffff\1\11\1\12\1\13\1\10\1\2\2\uffff\1\7\1\uffff\1\6\1\5";
    static final String[] dfa_25s = {
            "\1\2\1\uffff\1\1\37\uffff\1\10\6\uffff\1\3\74\uffff\1\4\1\uffff\1\5\1\6\1\7\4\1",
            "",
            "\1\12\13\uffff\2\12\4\uffff\15\12\3\uffff\1\11\2\12\3\uffff\2\12\1\uffff\4\12\1\uffff\4\12\6\uffff\1\12\1\uffff\6\12\1\uffff\5\12\7\uffff\2\12\1\uffff\2\12\1\uffff\13\12\1\uffff\1\12\2\uffff\2\12\1\uffff\1\12",
            "",
            "",
            "\1\13",
            "",
            "",
            "",
            "",
            "",
            "\1\14\1\uffff\1\15",
            "\1\16\1\uffff\1\17\37\uffff\1\17\6\uffff\1\17\21\uffff\1\17\6\uffff\1\17\5\uffff\7\17\13\uffff\1\17\1\uffff\1\17\3\uffff\1\17\5\uffff\1\17\1\uffff\7\17",
            "",
            "\2\17\6\uffff\1\20\2\uffff\2\17\1\uffff\3\17\12\uffff\5\17\2\uffff\4\17\7\uffff\2\17\1\uffff\2\17\1\uffff\13\17\4\uffff\1\17",
            "",
            ""
    };
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = dfa_14;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_19;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "4348:1: (this_LiteralExpr_0= ruleLiteralExpr | ( () ( (otherlv_2= RULE_ID ) ) ) | ( () otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= '|' ) | ( () otherlv_10= 'if' ( (lv_cond_11_0= ruleExpr ) ) otherlv_12= 'then' ( (lv_then_13_0= ruleExpr ) ) ( ( ( 'else' )=>otherlv_14= 'else' ) ( (lv_else_15_0= ruleExpr ) ) )? ) | ( () otherlv_17= 'new' ( (otherlv_18= RULE_ID ) ) otherlv_19= '{' ( (lv_fieldExprs_20_0= ruleFieldExpr ) ) (otherlv_21= ',' ( (lv_fieldExprs_22_0= ruleFieldExpr ) ) )* otherlv_23= '}' ) | ( () otherlv_25= 'new' ( (otherlv_26= RULE_ID ) ) otherlv_27= '{' ( (lv_exprs_28_0= ruleExpr ) ) (otherlv_29= ',' ( (lv_exprs_30_0= ruleExpr ) ) )* otherlv_31= '}' ) | ( () otherlv_33= 'new' ( (otherlv_34= RULE_ID ) ) otherlv_35= '[' ( (lv_exprs_36_0= ruleExpr ) ) (otherlv_37= ',' ( (lv_exprs_38_0= ruleExpr ) ) )* otherlv_39= ']' ) | ( () ( (otherlv_41= RULE_ID ) ) otherlv_42= '(' ( ( (lv_args_43_0= ruleExpr ) ) (otherlv_44= ',' ( (lv_args_45_0= ruleExpr ) ) )* )? otherlv_46= ')' ) | ( () otherlv_48= 'spec' ( (otherlv_49= RULE_ID ) ) otherlv_50= '(' ( ( (lv_args_51_0= ruleExpr ) ) (otherlv_52= ',' ( (lv_args_53_0= ruleExpr ) ) )* )? otherlv_54= ')' ) | this_UnusedExpr_55= ruleUnusedExpr | (otherlv_56= '(' this_Expr_57= ruleExpr otherlv_58= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000080003E000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000003C010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000038010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000030010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000002000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000007FD80010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000782000012L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000001F002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000080001E002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000001C012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000018012L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000010012L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0001B00000000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8000204000000050L,0x0007F4114007F040L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x3000000000200000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0E00000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020008000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x000000007ED80000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000180000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0006000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0050000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0080000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0080008000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000214000000050L,0x0007F4114007F040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000008000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});

}